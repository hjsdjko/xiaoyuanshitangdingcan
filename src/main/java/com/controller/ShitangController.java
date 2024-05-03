
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 食堂
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shitang")
public class ShitangController {
    private static final Logger logger = LoggerFactory.getLogger(ShitangController.class);

    private static final String TABLE_NAME = "shitang";

    @Autowired
    private ShitangService shitangService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private CartService cartService;//购物车
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private MeishiService meishiService;//美食
    @Autowired
    private MeishiCollectionService meishiCollectionService;//美食收藏
    @Autowired
    private MeishiCommentbackService meishiCommentbackService;//美食评价
    @Autowired
    private MeishiOrderService meishiOrderService;//美食订单
    @Autowired
    private NewsService newsService;//新闻公告
    @Autowired
    private ShangjiaService shangjiaService;//商家
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("商家".equals(role))
            params.put("shangjiaId",request.getSession().getAttribute("userId"));
        params.put("shitangDeleteStart",1);params.put("shitangDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = shitangService.queryPage(params);

        //字典表数据转换
        List<ShitangView> list =(List<ShitangView>)page.getList();
        for(ShitangView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShitangEntity shitang = shitangService.selectById(id);
        if(shitang !=null){
            //entity转view
            ShitangView view = new ShitangView();
            BeanUtils.copyProperties( shitang , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShitangEntity shitang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shitang:{}",this.getClass().getName(),shitang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ShitangEntity> queryWrapper = new EntityWrapper<ShitangEntity>()
            .eq("shitang_name", shitang.getShitangName())
            .eq("shitang_types", shitang.getShitangTypes())
            .eq("shitang_add", shitang.getShitangAdd())
            .eq("shitang_delete", shitang.getShitangDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShitangEntity shitangEntity = shitangService.selectOne(queryWrapper);
        if(shitangEntity==null){
            shitang.setShitangClicknum(1);
            shitang.setShitangDelete(1);
            shitang.setInsertTime(new Date());
            shitang.setCreateTime(new Date());
            shitangService.insert(shitang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShitangEntity shitang, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,shitang:{}",this.getClass().getName(),shitang.toString());
        ShitangEntity oldShitangEntity = shitangService.selectById(shitang.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(shitang.getShitangPhoto()) || "null".equals(shitang.getShitangPhoto())){
                shitang.setShitangPhoto(null);
        }

            shitangService.updateById(shitang);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ShitangEntity> oldShitangList =shitangService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ShitangEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ShitangEntity shitangEntity = new ShitangEntity();
            shitangEntity.setId(id);
            shitangEntity.setShitangDelete(2);
            list.add(shitangEntity);
        }
        if(list != null && list.size() >0){
            shitangService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ShitangEntity> shitangList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ShitangEntity shitangEntity = new ShitangEntity();
//                            shitangEntity.setShitangUuidNumber(data.get(0));                    //食堂编号 要改的
//                            shitangEntity.setShitangName(data.get(0));                    //食堂名称 要改的
//                            shitangEntity.setShitangPhoto("");//详情和图片
//                            shitangEntity.setShitangTypes(Integer.valueOf(data.get(0)));   //食堂类型 要改的
//                            shitangEntity.setShitangAdd(data.get(0));                    //食堂地址 要改的
//                            shitangEntity.setShitangClicknum(Integer.valueOf(data.get(0)));   //食堂热度 要改的
//                            shitangEntity.setShitangContent("");//详情和图片
//                            shitangEntity.setShitangDelete(1);//逻辑删除字段
//                            shitangEntity.setInsertTime(date);//时间
//                            shitangEntity.setCreateTime(date);//时间
                            shitangList.add(shitangEntity);


                            //把要查询是否重复的字段放入map中
                                //食堂编号
                                if(seachFields.containsKey("shitangUuidNumber")){
                                    List<String> shitangUuidNumber = seachFields.get("shitangUuidNumber");
                                    shitangUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shitangUuidNumber = new ArrayList<>();
                                    shitangUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shitangUuidNumber",shitangUuidNumber);
                                }
                        }

                        //查询是否重复
                         //食堂编号
                        List<ShitangEntity> shitangEntities_shitangUuidNumber = shitangService.selectList(new EntityWrapper<ShitangEntity>().in("shitang_uuid_number", seachFields.get("shitangUuidNumber")).eq("shitang_delete", 1));
                        if(shitangEntities_shitangUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShitangEntity s:shitangEntities_shitangUuidNumber){
                                repeatFields.add(s.getShitangUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [食堂编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shitangService.insertBatch(shitangList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = shitangService.queryPage(params);

        //字典表数据转换
        List<ShitangView> list =(List<ShitangView>)page.getList();
        for(ShitangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShitangEntity shitang = shitangService.selectById(id);
            if(shitang !=null){

                //点击数量加1
                shitang.setShitangClicknum(shitang.getShitangClicknum()+1);
                shitangService.updateById(shitang);

                //entity转view
                ShitangView view = new ShitangView();
                BeanUtils.copyProperties( shitang , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ShitangEntity shitang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shitang:{}",this.getClass().getName(),shitang.toString());
        Wrapper<ShitangEntity> queryWrapper = new EntityWrapper<ShitangEntity>()
            .eq("shitang_uuid_number", shitang.getShitangUuidNumber())
            .eq("shitang_name", shitang.getShitangName())
            .eq("shitang_types", shitang.getShitangTypes())
            .eq("shitang_add", shitang.getShitangAdd())
            .eq("shitang_clicknum", shitang.getShitangClicknum())
            .eq("shitang_delete", shitang.getShitangDelete())
//            .notIn("shitang_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShitangEntity shitangEntity = shitangService.selectOne(queryWrapper);
        if(shitangEntity==null){
            shitang.setShitangClicknum(1);
            shitang.setShitangDelete(1);
            shitang.setInsertTime(new Date());
            shitang.setCreateTime(new Date());
        shitangService.insert(shitang);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

