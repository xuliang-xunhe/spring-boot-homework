package com.xunhe.bj.Controller;

import ch.qos.logback.classic.Logger;
import com.xunhe.bj.Config.AuthenticationInterceptor;
import com.xunhe.bj.Config.PassToken;
import com.xunhe.bj.Config.UserLoginToken;
import com.xunhe.bj.json.*;
import com.xunhe.bj.po.TblUsers;
import com.xunhe.bj.po.TblUsersList;
import com.xunhe.bj.po.UsersListJK;
import com.xunhe.bj.service.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController
{
    Logger logger = (Logger) LoggerFactory.getLogger(getClass());
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private UsersService usersService;
    @Autowired
    TokenService tokenService;

    /**
     * 注册画面下拉菜单取得
     */
    @PassToken
    @GetMapping("/UserItem")
    public ResUserItem UserItem(){
        Map<String, Object> m1 = new HashMap();

        List Item1 = departmentService.selectAll();
        List Item2 = projectService.selectAll();
        List Item3 = teamService.selectAll();

        ResUserItem res = new ResUserItem();

        if (!(Item1.size()==0) &&
                !(Item2.size()==0) &&
                !(Item3.size()==0)){
            m1.put("department",Item1);
            m1.put("project",Item2);
            m1.put("team",Item3);
            res.setResultCode("0");
            res.setResultMsg("UserItem取得成功");
            res.setResmap(m1);
        }
        else{
            logger.error("UserItem:TBL select error!!!(department.size:"+Item1.size()+
                    " project.size:"+Item2.size()+" team.size:"+Item3.size()+")");
            res.setResultCode("1");
            res.setResultMsg("UserItem取得失败");
            res.setResult(null);
        }
        return res;
    }
    /**
     * 用户注册
     * @param request TblUsers
     * @return Res
     */
    @PassToken
    @PostMapping(value = "/User")
    public Res insertUser(@RequestBody TblUsers request){
        Res res = new Res();

        TblUsers UserIdcheck = new TblUsers(request.getId());
        List<TblUsers> UserIdcheckList = usersService.selecturs(UserIdcheck);

        //Id在DB中存在
        if (UserIdcheckList.size() == 1){
            if (UserIdcheckList.get(0).getDeleteKbn().equals("0")){
                logger.error("UserInsert: Id在DB中存在!!!("+request.getId()+")");
                res.setResultCode("1");
                res.setResultMsg("该用户已存在！");
                res.setResult(null);
                return res;
            }
            else {
                if (usersService.deleteUsers(request.getId())!=1) {
                    logger.error("UserInsert: Id在DB中存在,并且deleteKbn=1,但删除时发生了错误!!!("+request.getId()+")");
                    res.setResultCode("2");
                    res.setResultMsg("注册失败，请联系管理员！");
                    res.setResult(null);
                    return res;
                }
            }
        }
        request.setDeleteKbn("0");
        //状态设置为未承认
        request.setStatus("0");
        if (usersService.addUsers(request)==1){
            logger.info("UserInsert: "+request.getName()+"("+request.getId()+") 注册成功!");
            res.setResultCode("0");
            res.setResultMsg("注册成功，请等待主管进行承认（承认后才能登陆）");
            res.setResult(null);
            return  res;
        }else {
            logger.error("UserInsert: 其他错误("+request.getId()+")");
            res.setResultCode("3");
            res.setResultMsg("注册失败，请联系管理员！");
            res.setResult(null);
            return  res;
        }
    }
    /**
     * 用户承认
     * @param request IntUser
     * @return Res
     */
    @UserLoginToken
    @PutMapping(value = "/User/admit")
    public Res admitUser(@RequestBody IntUser request){
        Res res = new Res();
        TblUsers loginIdcheck = new TblUsers(request.getLoginId());
        List<TblUsers> loginIdcheckList = usersService.selecturs(loginIdcheck);

        //loginId在DB中不存在
        if (loginIdcheckList.size() == 0){
            logger.error("UserAdmit:loginId在DB中不存在!!!("+request.getLoginId()+")");
            res.setResultCode("1");
            res.setResultMsg("出错啦!请联系管理员");
            res.setResult(null);
            return res;
        }

        //不是管理员
        if (!loginIdcheckList.get(0).getManagerKbn().equals("1")){
            //loginId≠检索id
            if (!request.getLoginId().equals(request.getId())){
                logger.error("UserAdmit:非管理员且loginId≠检索id!!!("+request.getLoginId()+":"+request.getId()+")");
                res.setResultCode("2");
                res.setResultMsg("非管理员不能进行承认!");
                res.setResult(null);
                return res;
            }
        }

        TblUsers UserIdcheck = new TblUsers(request.getId());
        List<TblUsers> UserIdcheckList = usersService.selecturs(UserIdcheck);

        //id在DB中不存在
        if (UserIdcheckList.size() == 0){
            logger.error("UserAdmit: id在DB中不存在!!!("+request.getId()+")");
            res.setResultCode("3");
            res.setResultMsg("出错啦!请联系管理员");
            res.setResult(null);
            return res;
        }
        //状态设置为已承认
        request.setStatus("1");
        if (usersService.updateUsers(request)==1){
            logger.info("UserAdmit: "+UserIdcheckList.get(0).getName()+"("+request.getId()+") 已承认!");
            res.setResultCode("0");
            res.setResultMsg("已承认，请通知该用户("+UserIdcheckList.get(0).getName()+")");
            res.setResult(null);
            return  res;
        }else {
            logger.error("UserAdmit: 其他错误("+request.getId()+")");
            res.setResultCode("4");
            res.setResultMsg("承认失败，请联系管理员！");
            res.setResult(null);
            return  res;
        }
    }
    /**
     * 登陆
     * @param request TblUsers
     * @return ResLogin
     */
    @PassToken
    @PostMapping("/login")
    public ResLogin login(@RequestBody TblUsers request){
        ResLogin res = new ResLogin();
        request.setDeleteKbn("0");
        //用[id+密码]进行查询
        List<TblUsers> UserList =usersService.selectPS(request);
        //查询结果件数=1
        if (UserList.size() == 1){
            //该用户已经被承认
            if (UserList.get(0).getStatus().equals("1")){
                //取得token
                String token = tokenService.getToken(UserList.get(0));
                res.setToken(token);
                //登陆成功
                res.setResultCode("0");
                res.setResultMsg("登陆成功");
                //用户权限
                res.setManager_kbn(UserList.get(0).getManagerKbn());
                //用户名
                res.setName(UserList.get(0).getName());
                res.setResult(null);
            }
            else {
                //该用户未被承认
                logger.warn("login:未承认用户("+request.getId()+")");
                res.setResultCode("1");
                res.setResultMsg("还没有被承认！请耐心等待。");
                res.setManager_kbn(UserList.get(0).getManagerKbn());
                res.setResult(null);
            }
        }
        else{
            //查询结果件数≠1
            logger.error("login:Id或密码错误("+request.getId()+")");
            res.setResultCode("2");
            res.setResultMsg("ID或密码错误！");
            res.setResult(null);
        }
        return  res;
    }
    /**
     * 用户信息查询（管理员） by id
     * @param loginId String, id String
     * @return ResUserSelect
     */
    @UserLoginToken
    @GetMapping(value = "/User/{loginId}/{id}" )
    public ResUserSelect selectus1(@PathVariable("loginId") String loginId,@PathVariable("id") String id){

        ResUserSelect resx = new ResUserSelect();
        TblUsers UserLoginIdcheck = new TblUsers(loginId);
        List<TblUsers> UserLoginIdcheckList = usersService.selecturs(UserLoginIdcheck);

        //loginId在DB中不存在
        if (UserLoginIdcheckList.size() == 0){
            logger.error("UsersSelect:loginId在DB中不存在!!!("+loginId+")");
            resx.setResultCode("1");
            resx.setResultMsg("出错啦!请联系管理员");
            resx.setResult(null);
            return resx;
        }

        //不是管理员
        if (!UserLoginIdcheckList.get(0).getManagerKbn().equals("1")){
            //loginId≠检索id
            if (!loginId.equals(id)){
                logger.error("UsersSelect:非管理员且loginId≠检索id!!!("+loginId+":"+id+")");
                resx.setResultCode("2");
                resx.setResultMsg("非管理员不能查看别人的注册信息!");
                resx.setResult(null);
                return resx;
            }
        }
        //检索条件:id
        TblUsers selectJouken = new TblUsers(id);
        List<TblUsers> UserList = usersService.selecturs(selectJouken);
        resx.setTblUsers(UserList);

        //select件数为0
        if (UserList.size() == 0){
            logger.warn("UsersSelect:select件数为0(LoginId:"+loginId+")");
            resx.setResultCode("3");
            resx.setResultMsg("检索结果为空!");
            resx.setResult(null);
        }
        else{
            resx.setResultCode("0");
            resx.setResultMsg("用户信息检索成功");
            logger.info("UsersSelect:select正常完了(LoginId:"+loginId+")");
        }
        return resx;
    }
    /**
     * 用户信息查询（非管理员） by id
     * @param id String
     * @return ResUserSelect
     */
    @UserLoginToken
    @GetMapping(value = "/User/{id}" )
    public ResUserSelect selectus2(@PathVariable("id") String id){

        ResUserSelect resx = new ResUserSelect();
        if (id.length() != 7){
            logger.error("UsersSelect(本人):输入的ＩＤ长度小于７位");
            resx.setResultCode("1");
            resx.setResultMsg("只能检索本人的信息，请输入完整的ＩＤ！");
            resx.setResult(null);
            return resx;
        }
        //检索条件:id
        TblUsers selectJouken = new TblUsers(id);
        List<TblUsers> UserList = usersService.selecturs(selectJouken);
        resx.setTblUsers(UserList);

        //select件数为0
        if (UserList.size() == 0){
            logger.warn("UsersSelect:select件数为0(id:"+id+")");
            resx.setResultCode("2");
            resx.setResultMsg("检索结果为空!");
            resx.setResult(null);
        }
        else{
            resx.setResultCode("0");
            resx.setResultMsg("用户信息检索成功");
            logger.info("UsersSelect:select正常完了(id:"+id+")");
        }
        return resx;
    }
    /**
     * 修改密码
     * @param request IntUserPassword
     * @return ResPSUP
     */
    @UserLoginToken
    @PutMapping(value = "/User/PSUP")
    public ResPSUP UpdatePswd(@RequestBody IntUserPassword request){
        ResPSUP res = new ResPSUP();
        //loginId为空
        if (request.getLoginId().isEmpty()){
            logger.error("UpdatePassword: LoginId为空!!!");
            res.setResultCode("1");
            res.setResultMsg("出错啦!请联系管理员");
            res.setResult(null);
            return res;
        }
        //loginId的User情报取得
        TblUsers UserLoginIdcheck = new TblUsers(request.getLoginId());
        UserLoginIdcheck.setDeleteKbn("0");
        List<TblUsers> UserLoginIdcheckList = usersService.selecturs(UserLoginIdcheck);

        //loginId在DB中不存在
        if (UserLoginIdcheckList.size() == 0){
            logger.error("UpdatePassword: LoginId在DB中不存在!!!("+request.getLoginId()+")");
            res.setResultCode("2");
            res.setResultMsg("出错啦!请联系管理员");
            res.setResult(null);
            return res;
        }

        //修改对象Id为空
        if (request.getId().isEmpty()){
            logger.error("UpdatePassword: 修改对象id为空!!!");
            res.setResultCode("3");
            res.setResultMsg("修改对象ID为空");
            res.setResult(null);
            return res;
        }
        //非管理员且loginId≠id
        if ((!request.getLoginId().equals(request.getId())) &&
                (!UserLoginIdcheckList.get(0).getManagerKbn().equals("1"))){
            logger.error("UserDelete: 非管理员不能修改别人的密码!!!（侵权者ＩＤ：" +
                    request.getLoginId() + "　要修改的id：" + request.getId() + "）");
            res.setResultCode("4");
            res.setResultMsg("非管理员不能修改别人的密码!");
            res.setResult(null);
            return res;
        }

        if (request.getPswdOld().isEmpty() ||
                request.getPswdNew().isEmpty()){
            logger.error("UpdatePassword: 新密码或旧密码为空!!!" +
                    "(操作者id:"+request.getId()+")");
            res.setResultCode("5");
            res.setResultMsg("新密码或旧密码为空!");
            res.setResult(null);
            return res;
        }

        TblUsers checkUser = new TblUsers(request.getId());
        checkUser.setPassword(request.getPswdOld());
        List<TblUsers> UserList =usersService.selectPS(checkUser);
        //旧密码错误
        if (UserList.size() != 1){
            logger.error("UpdatePassword: 旧密码错误!!!" +
                    "(操作者id:"+request.getId()+")");
            res.setResultCode("6");
            res.setResultMsg("旧密码错误!");
            res.setResult(null);
            return res;
        }

        if (usersService.updateUsers(request.getTblUsers())==1){
            //id及新密码设置
            TblUsers UserNew=new TblUsers(UserList.get(0).getId());
            UserNew.setPassword(request.getPswdNew());
            //新的加密后密码取得
            List<TblUsers> UserListNew =usersService.selectPS(UserNew);
            //加密后新密码设置
            UserList.get(0).setPassword(UserListNew.get(0).getPassword());

            //签发新令牌
            if (request.getLoginId().equals(request.getId())){
                String token = tokenService.getToken(UserList.get(0));
                res.setToken(token);
            }else {
                res.setToken(null);
            }


            logger.info("UpdatePassword: 密码正常变更("+
                    checkUser.getName()+"("+checkUser.getId()+"))");
            res.setResultCode("0");
            res.setResultMsg("密码变更成功!");
            return  res;
        }
        else{
            //什么都没变或更新不止一件
            logger.error("UpdatePassword: 什么都没变或更新不止一件!!!" +
                    "(操作者id:"+request.getId()+")");
            res.setResultCode("7");
            res.setResultMsg("出错啦!请联系管理员");
            return  res;
        }
    }
    /**
     * 查询用户一览（根据条件）
     * @param request IntUserList
     * @return ResUserSelectList
     */
    @UserLoginToken
    @PostMapping(value = "/User/List" )
    public ResUserSelectList selectusList(@RequestBody IntUserList request){

        ResUserSelectList resx = new ResUserSelectList();
        //loginId为空
        if (request.getLoginId().isEmpty()){
            logger.error("UsersSelectList:loginId为空!!!");
            resx.setResultCode("1");
            resx.setResultMsg("出错啦!请联系管理员");
            resx.setResult(null);
            return resx;
        }

        TblUsers LoginIdcheck = new TblUsers(request.getLoginId());
        List<TblUsers> LoginIdcheckList = usersService.selecturs(LoginIdcheck);

        //loginId在DB中不存在
        if (LoginIdcheckList.size() == 0){
            logger.error("UsersSelectList:loginId在DB中不存在!!!("+request.getLoginId()+")");
            resx.setResultCode("2");
            resx.setResultMsg("出错啦!请联系管理员");
            resx.setResult(null);
            return resx;
        }

        //不是管理员
        if (!LoginIdcheckList.get(0).getManagerKbn().equals("1")){
            logger.error("UsersSelectList:不是管理员!!!("+request.getLoginId()+")");
            resx.setResultCode("3");
            resx.setResultMsg("非管理员不能使用该功能！");
            resx.setResult(null);
            return resx;
        }
        //检索条件作成
        UsersListJK usersListJK=new UsersListJK(request.getTblUsers(),(request.getPage()-1)*request.getPageSize(),request.getPageSize());
        //当页List取得
        List<TblUsersList> UserList = usersService.selecturList(usersListJK);
        //总件数取得
        resx.setListsize(usersService.selecturListcount(usersListJK).toString());
        resx.setTblUsers(UserList);

        //select件数为0
        if (UserList.size() == 0){
            logger.warn("UsersSelectList:select件数为0(LoginId:"+request.getLoginId()+")");
            resx.setResultCode("4");
            resx.setResultMsg("检索结果为空!");
            resx.setResult(null);
        }
        else{
            resx.setResultCode("0");
            resx.setResultMsg("用户信息一览检索成功");
            logger.info("UsersSelectList:select正常完了(LoginId:"+request.getLoginId()+")");
        }
        return resx;
    }

    /**
     * 用户信息修改
     * @param request IntUser
     * @return Res
     */
    @UserLoginToken
    @PutMapping(value = "/User")
    public Res UpdateUser(@RequestBody IntUser request){
        Res res = new Res();
        //loginId为空
        if (request.getLoginId().isEmpty()){
            logger.error("UserUpdate: LoginId为空!!!");
            res.setResultCode("1");
            res.setResultMsg("出错啦!请联系管理员");
            res.setResult(null);
            return res;
        }
        TblUsers UserLoginIdcheck = new TblUsers(request.getLoginId());
        List<TblUsers> UserLoginIdcheckList = usersService.selecturs(UserLoginIdcheck);

        //loginId在DB中不存在
        if (UserLoginIdcheckList.size() == 0){
            logger.error("UserUpdate: loginId在DB中不存在!!!("+request.getLoginId()+")");
            res.setResultCode("2");
            res.setResultMsg("出错啦!请联系管理员");
            res.setResult(null);
            return res;
        }

        //Id为空
        if (request.getId().isEmpty()){
            logger.error("UserUpdate: id为空!!!");
            res.setResultCode("3");
            res.setResultMsg("出错啦!请联系管理员");
            res.setResult(null);
            return res;
        }
        //不是管理员
        if (!UserLoginIdcheckList.get(0).getManagerKbn().equals("1")){
            //loginId≠id
            if (!request.getLoginId().equals(request.getId())){
                logger.error("UserUpdate: 非管理员不能修改别人的用户情报!!!（侵权者id：" +
                        request.getLoginId() + "　要修改的id：" + request.getId() + "）");
                res.setResultCode("4");
                res.setResultMsg("非管理员不能使用该功能！");
                res.setResult(null);
                return res;
            }
        }

        TblUsers UserIdcheck = new TblUsers(request.getId());
        List<TblUsers> UserIdcheckList = usersService.selecturs(UserIdcheck);

        //id在DB中不存在
        if (UserIdcheckList.size() == 0){
            logger.error("UserUpdate: id在DB中不存在!!!("+request.getId()+")");
            res.setResultCode("5");
            res.setResultMsg("出错啦!请联系管理员");
            res.setResult(null);
            return res;
        }

        if (usersService.updateUsers(request.getTblUsers())==1){
            logger.info("UserUpdate: 用户信息正常变更("+request.getId()+")");
            res.setResultCode("0");
            res.setResultMsg("用户信息正常变更");
            return  res;
        }
        else{
            logger.error("UserUpdate: 什么都没变或更新不止一件!!!("+request.getId()+")");
            res.setResultCode("6");
            res.setResultMsg("出错啦!请联系管理员");
            return  res;
        }
    }

    /**
     * 用户注销
     * @param request IntUser
     * @return Res
     */
    @UserLoginToken
    @DeleteMapping(value = "/User")
    public Res DeleteUser(@RequestBody IntUser  request){
        Res res = new Res();
        //loginId为空
        if (request.getLoginId().isEmpty()){
            logger.error("UserDelete: LoginId为空!!!");
            res.setResultCode("1");
            res.setResultMsg("出错啦!请联系管理员");
            res.setResult(null);
            return res;
        }
        TblUsers UserLoginIdcheck = new TblUsers(request.getLoginId());
        List<TblUsers> UserLoginIdcheckList = usersService.selecturs(UserLoginIdcheck);

        //loginId在DB中不存在
        if (UserLoginIdcheckList.size() == 0){
            logger.error("UserDelete: loginId在DB中不存在!!!("+request.getLoginId()+")");
            res.setResultCode("2");
            res.setResultMsg("出错啦!请联系管理员");
            res.setResult(null);
            return res;
        }

        //id为空
        if (request.getId().isEmpty()){
            logger.error("UserDelete: 要注销的id为空!!!");
            res.setResultCode("3");
            res.setResultMsg("出错啦!请联系管理员");
            res.setResult(null);
            return res;
        }
        //不是管理员
        if (!UserLoginIdcheckList.get(0).getManagerKbn().equals("1")){
            //loginId≠id
            if (!request.getLoginId().equals(request.getId())){
                logger.error("UserDelete: 非管理员不能注销别人的id!!!（侵权者id：" +
                        request.getLoginId() + "　要注销的id：" + request.getId() + "）");
                res.setResultCode("4");
                res.setResultMsg("非管理员不能注销别人的id");
                res.setResult(null);
                return res;
            }
        }

        TblUsers UserIdcheck = new TblUsers(request.getId());
        List<TblUsers> UserIdcheckList = usersService.selecturs(UserIdcheck);

        //id在DB中不存在
        if (UserIdcheckList.size() == 0){
            logger.error("UserDelete: 要注销的id在DB中不存在!!!("+request.getId()+")");
            res.setResultCode("5");
            res.setResultMsg("出错啦!请联系管理员");
            res.setResult(null);
            return res;
        }
        if (usersService.deleteUsers(request.getId())==1){
            logger.info("UserDelete： " + UserIdcheckList.get(0).getName() + "(" + request.getId() + ")注销成功 by "+
                    UserLoginIdcheckList.get(0).getName() + "(" + request.getLoginId() + ")");
            res.setResultCode("0");
            res.setResultMsg("注销成功");
            return  res;
        }
        else{
            //Id在DB中不存在或删除的不止一件
            logger.error("UserDelete: Id在DB中不存在或删除的不止一件！！！（要注销的IＤ：" + request.getId() + "）");
            res.setResultCode("6");
            res.setResultMsg("出错啦!请联系管理员");
            return  res;
        }
    }
}
