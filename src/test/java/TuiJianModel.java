import com.gxtravel.entity.Scenic;
import com.gxtravel.entity.ScenicScore;
import com.gxtravel.entity.Statistic;
import com.gxtravel.entity.User;
import com.gxtravel.service.RecommendService;
import com.gxtravel.service.ScenicService;
import com.gxtravel.service.UserService;
import com.gxtravel.utils.ExportUtil;
import com.gxtravel.utils.GetSimilarItem;
import com.gxtravel.utils.MyUserBasedRecommender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件位置
@ContextConfiguration({ "classpath:spring/applicationContext.xml", "classpath:spring/springmvc.xml" })
public class TuiJianModel {

    @Autowired
    RecommendService recommendService;

    @Autowired
    ScenicService scenicService;

    @Autowired
    UserService userService;


    @Test
    public void batchInsert() throws Exception{
        List<Scenic> scenicslist = new ArrayList<>();
        //主题：自然山水，沙滩海岸，主题乐园，田园风光，名胜古迹
        scenicslist.add(new Scenic(1,"漓江轻舟游","自然山水","桂林","特征略","image/scenic/pic/漓江游.jpg",0));
        scenicslist.add(new Scenic(2,"象山景区","自然山水","桂林","特征略","image/scenic/pic/象山景区.jpg",0));
        scenicslist.add(new Scenic(3,"遇龙河漂流","自然山水","桂林","特征略","image/scenic/pic/象山景区.jpg",0));
        scenicslist.add(new Scenic(4,"银子岩","自然山水","桂林","特征略","image/scenic/pic/银子岩.jpg",0));
        scenicslist.add(new Scenic(5,"四湖轻舟游","自然山水","桂林","特征略","image/scenic/pic/四湖轻舟游.jpg",0));
        scenicslist.add(new Scenic(6,"八寨沟","自然山水","钦州","特征略","image/scenic/pic/八寨沟.jpg",0));
        scenicslist.add(new Scenic(7,"龙潭国家森林公园","自然山水","贵港","特征略","image/scenic/pic/龙潭国家森林公园.jpg",0));
        scenicslist.add(new Scenic(8,"东兴屏峰雨林公园","自然山水","防城港","特征略","image/scenic/pic/东兴屏峰雨林公园.jpg",0));
        scenicslist.add(new Scenic(9,"铜石岭","自然山水","玉林","特征略","image/scenic/pic/铜石岭.jpg",0));
        scenicslist.add(new Scenic(10,"勾漏洞","自然山水","玉林","特征略","image/scenic/pic/勾漏洞.jpg",0));
        scenicslist.add(new Scenic(11,"大容山森林公园","自然山水","玉林","特征略","image/scenic/pic/大容山森林公园.jpg",0));
        scenicslist.add(new Scenic(12,"七百弄国家地质公园","自然山水","河池","特征略","image/scenic/pic/七百弄国家地质公园.jpg",0));
        scenicslist.add(new Scenic(13,"巴马水晶宫","自然山水","河池","特征略","image/scenic/pic/巴马水晶宫.jpg",0));
        scenicslist.add(new Scenic(14,"百魔洞","自然山水","河池","特征略","image/scenic/pic/百魔洞.jpg",0));
        scenicslist.add(new Scenic(15,"天龙顶国家山地公园","自然山水","梧州","特征略","image/scenic/pic/天龙顶国家山地公园.jpg",0));
        scenicslist.add(new Scenic(16,"大石围天坑群","自然山水","百色","特征略","image/scenic/pic/大石围天坑群.jpg",0));
        scenicslist.add(new Scenic(17,"德天瀑布景区","自然山水","崇左","特征略","image/scenic/pic/德天瀑布景区.jpg",0));
        scenicslist.add(new Scenic(18,"通灵大峡谷","自然山水","百色","特征略","image/scenic/pic/通灵大峡谷.jpg",0));
        scenicslist.add(new Scenic(19,"鹅泉","自然山水","百色","特征略","image/scenic/pic/鹅泉.jpg",0));
        scenicslist.add(new Scenic(20,"古龙山大峡谷","自然山水","百色","特征略","image/scenic/pic/古龙山大峡谷.jpg",0));
        scenicslist.add(new Scenic(21,"姑婆山","自然山水","贺州","特征略","image/scenic/pic/姑婆山.jpg",0));
        scenicslist.add(new Scenic(22,"玉石林风景区","自然山水","贺州","特征略","image/scenic/pic/玉石林风景区.jpg",0));
        scenicslist.add(new Scenic(23,"紫云洞景区","自然山水","贺州","特征略","image/scenic/pic/紫云洞景区.jpg",0));
        scenicslist.add(new Scenic(24,"石门仙湖景区","自然山水","柳州","特征略","image/scenic/pic/石门仙湖景区.jpg",0));
        scenicslist.add(new Scenic(25,"丹洲景区","自然山水","柳州","特征略","image/scenic/pic/龙虎山风景区.jpg",0));
        scenicslist.add(new Scenic(26,"龙虎山风景区","自然山水","南宁","特征略","image/scenic/pic/龙虎山风景区.jpg",0));
        scenicslist.add(new Scenic(27,"龙潭公园","自然山水","柳州","特征略","image/scenic/pic/龙潭公园.jpg",0));
        scenicslist.add(new Scenic(28,"金海湾红树林生态旅游区","自然山水","北海","特征略","image/scenic/pic/北海金海湾红树林生态旅游区.jpg",0));
        scenicslist.add(new Scenic(29,"青秀山","自然山水","南宁","特征略","image/scenic/pic/青秀山.jpg",0));
        scenicslist.add(new Scenic(30,"大明山","自然山水","南宁","特征略","image/scenic/pic/大明山.jpg",0));
        scenicslist.add(new Scenic(31,"西山风景名胜区","自然山水","贵港","特征略","image/scenic/pic/西山风景名胜区.jpg",0));

        scenicslist.add(new Scenic(32,"涠洲岛","沙滩海岸","北海","特征略","image/scenic/pic/涠洲岛.jpg",0));
        scenicslist.add(new Scenic(33,"五彩滩","沙滩海岸","北海","特征略","image/scenic/pic/五彩滩.jpg",0));
        scenicslist.add(new Scenic(34,"滴水丹屏","沙滩海岸","北海","特征略","image/scenic/pic/滴水丹屏.jpg",0));
        scenicslist.add(new Scenic(35,"北海银滩旅游度假区","沙滩海岸","北海","特征略","image/scenic/pic/北海银滩旅游度假区.jpg",0));
        scenicslist.add(new Scenic(36,"万尾金滩","沙滩海岸","防城港","特征略","image/scenic/pic/万尾金滩.jpg",0));
        scenicslist.add(new Scenic(37,"白浪滩","沙滩海岸","防城港","特征略","image/scenic/pic/白浪滩.jpg",0));
        scenicslist.add(new Scenic(38,"江山半岛","沙滩海岸","防城港","特征略","image/scenic/pic/江山半岛.jpg",0));
        scenicslist.add(new Scenic(39,"三娘湾","沙滩海岸","钦州","特征略","image/scenic/pic/三娘湾.jpg",0));

        scenicslist.add(new Scenic(40,"北海海底世界","主题乐园","北海","特征略","image/scenic/pic/北海海底世界.jpg",0));
        scenicslist.add(new Scenic(41,"海洋之窗","主题乐园","北海","特征略","image/scenic/pic/海洋之窗.jpg",0));
        scenicslist.add(new Scenic(42,"南宁动物园","主题乐园","南宁","特征略","image/scenic/pic/南宁动物园.jpg",0));
        scenicslist.add(new Scenic(43,"柳州动物园","主题乐园","柳州","特征略","image/scenic/pic/柳州动物园.jpg",0));
        scenicslist.add(new Scenic(44,"瑶寨九龙潭漂流","主题乐园","防城港","特征略","image/scenic/pic/瑶寨九龙潭漂流.jpg",0));
        scenicslist.add(new Scenic(45,"十万大山温泉","主题乐园","防城港","特征略","image/scenic/pic/十万大山温泉.jpg",0));
        scenicslist.add(new Scenic(46,"贺州温泉","主题乐园","贺州","特征略","image/scenic/pic/贺州温泉.jpg",0));
        scenicslist.add(new Scenic(47,"龙谷湾恐龙公园","主题乐园","崇左","特征略","image/scenic/pic/龙谷湾恐龙公园.jpg",0));
        scenicslist.add(new Scenic(48,"青牛谷漂流","主题乐园","贵港","特征略","image/scenic/pic/青牛谷漂流.jpg",0));

        scenicslist.add(new Scenic(49,"象州古象温泉度假村","田园风光","来宾","特征略","image/scenic/pic/象州古象温泉度假村.jpg",0));
        scenicslist.add(new Scenic(50,"龙脊梯田","田园风光","桂林","特征略","image/scenic/pic/龙脊梯田.jpg",0));
        scenicslist.add(new Scenic(51,"世外桃源","田园风光","桂林","特征略","image/scenic/pic/世外桃源.jpg",0));
        scenicslist.add(new Scenic(52,"三江侗乡","田园风光","柳州","特征略","image/scenic/pic/三江侗乡.jpg",0));
        scenicslist.add(new Scenic(53,"明仕田园","田园风光","崇左","特征略","image/scenic/pic/明仕田园.jpg",0));
        scenicslist.add(new Scenic(54,"巴马长寿村","田园风光","河池","特征略","image/scenic/pic/巴马长寿村.jpg",0));

        scenicslist.add(new Scenic(55,"独秀峰","名胜古迹","桂林","特征略","image/scenic/pic/独秀峰.jpg",0));
        scenicslist.add(new Scenic(56,"兴坪古镇","名胜古迹","桂林","特征略","image/scenic/pic/兴坪古镇.jpg",0));
        scenicslist.add(new Scenic(57,"日月双塔","名胜古迹","桂林","特征略","image/scenic/pic/日月双塔.jpg",0));
        scenicslist.add(new Scenic(58,"广西民族博物馆","名胜古迹","南宁","特征略","image/scenic/pic/广西民族博物馆.jpg",0));
        scenicslist.add(new Scenic(59,"程阳八寨","名胜古迹","柳州","特征略","image/scenic/pic/程阳八寨.jpg",0));
        scenicslist.add(new Scenic(60,"柳侯公园","名胜古迹","柳州","特征略","image/scenic/pic/柳侯公园.jpg",0));
        scenicslist.add(new Scenic(61,"黄姚古镇","名胜古迹","贺州","特征略","image/scenic/pic/黄姚古镇.jpg",0));
        scenicslist.add(new Scenic(62,"百色起义纪念馆","名胜古迹","百色","特征略","image/scenic/pic/百色起义纪念馆.jpg",0));
        scenicslist.add(new Scenic(63,"凭祥友谊关","名胜古迹","崇左","特征略","image/scenic/pic/凭祥友谊关.jpg",0));
        scenicslist.add(new Scenic(64,"刘三姐故里景区","名胜古迹","河池","特征略","image/scenic/pic/刘三姐故里景区.jpg",0));
        scenicslist.add(new Scenic(65,"真武阁","名胜古迹","玉林","特征略","image/scenic/pic/真武阁.jpg",0));
        scenicslist.add(new Scenic(66,"云天宫","名胜古迹","玉林","特征略","image/scenic/pic/云天宫.jpg",0));
        scenicslist.add(new Scenic(67,"灵渠","名胜古迹","桂林","特征略","image/scenic/pic/灵渠.jpg",0));
        scenicslist.add(new Scenic(68,"太平天国金田起义旧址","名胜古迹","贵港","特征略","image/scenic/pic/太平天国金田起义旧址.jpg",0));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date birthday = sdf.parse("2000/1/1");
        List<User> userlist = new ArrayList<>();
        userlist.add(new User(1,"user1","e10adc3949ba59abbe56e057f20f883e","user1","user1@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(2,"user2","e10adc3949ba59abbe56e057f20f883e","user2","user2@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(3,"user3","e10adc3949ba59abbe56e057f20f883e","user3","user3@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(4,"user4","e10adc3949ba59abbe56e057f20f883e","user4","user4@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(5,"user5","e10adc3949ba59abbe56e057f20f883e","user5","user5@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(6,"user6","e10adc3949ba59abbe56e057f20f883e","user6","user6@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(7,"user7","e10adc3949ba59abbe56e057f20f883e","user7","user7@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(8,"user8","e10adc3949ba59abbe56e057f20f883e","user8","user8@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(9,"user9","e10adc3949ba59abbe56e057f20f883e","user9","user9@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(10,"user10","e10adc3949ba59abbe56e057f20f883e","user10","user10@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(11,"user11","e10adc3949ba59abbe56e057f20f883e","user11","user11@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(12,"user12","e10adc3949ba59abbe56e057f20f883e","user12","user12@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(13,"user13","e10adc3949ba59abbe56e057f20f883e","user13","user13@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(14,"user14","e10adc3949ba59abbe56e057f20f883e","user14","user14@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(15,"user15","e10adc3949ba59abbe56e057f20f883e","user15","user15@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(16,"user16","e10adc3949ba59abbe56e057f20f883e","user16","user16@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(17,"user17","e10adc3949ba59abbe56e057f20f883e","user17","user17@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(18,"user18","e10adc3949ba59abbe56e057f20f883e","user18","user18@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(19,"user19","e10adc3949ba59abbe56e057f20f883e","user19","user19@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(20,"user20","e10adc3949ba59abbe56e057f20f883e","user20","user20@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(21,"user21","e10adc3949ba59abbe56e057f20f883e","user21","user21@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(22,"user22","e10adc3949ba59abbe56e057f20f883e","user22","user22@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(23,"user23","e10adc3949ba59abbe56e057f20f883e","user23","user23@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(24,"user24","e10adc3949ba59abbe56e057f20f883e","user24","user24@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(25,"user25","e10adc3949ba59abbe56e057f20f883e","user25","user25@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(26,"user26","e10adc3949ba59abbe56e057f20f883e","user26","user26@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(27,"user27","e10adc3949ba59abbe56e057f20f883e","user27","user27@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(28,"user28","e10adc3949ba59abbe56e057f20f883e","user28","user28@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(29,"user29","e10adc3949ba59abbe56e057f20f883e","user29","user29@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(30,"user30","e10adc3949ba59abbe56e057f20f883e","user30","user30@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(31,"user31","e10adc3949ba59abbe56e057f20f883e","user31","user31@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(32,"user32","e10adc3949ba59abbe56e057f20f883e","user32","user32@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(33,"user33","e10adc3949ba59abbe56e057f20f883e","user33","user33@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(34,"user34","e10adc3949ba59abbe56e057f20f883e","user34","user34@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(35,"user35","e10adc3949ba59abbe56e057f20f883e","user35","user35@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(36,"user36","e10adc3949ba59abbe56e057f20f883e","user36","user36@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(37,"user37","e10adc3949ba59abbe56e057f20f883e","user37","user37@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(38,"user38","e10adc3949ba59abbe56e057f20f883e","user38","user38@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(39,"user39","e10adc3949ba59abbe56e057f20f883e","user39","user39@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(40,"user40","e10adc3949ba59abbe56e057f20f883e","user40","user40@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(41,"user41","e10adc3949ba59abbe56e057f20f883e","user41","user41@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(42,"user42","e10adc3949ba59abbe56e057f20f883e","user42","user42@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(43,"user43","e10adc3949ba59abbe56e057f20f883e","user43","user43@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(44,"user44","e10adc3949ba59abbe56e057f20f883e","user44","user44@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(45,"user45","e10adc3949ba59abbe56e057f20f883e","user45","user45@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(46,"user46","e10adc3949ba59abbe56e057f20f883e","user46","user46@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(47,"user47","e10adc3949ba59abbe56e057f20f883e","user47","user47@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(48,"user48","e10adc3949ba59abbe56e057f20f883e","user48","user48@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(49,"user49","e10adc3949ba59abbe56e057f20f883e","user49","user49@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(50,"user50","e10adc3949ba59abbe56e057f20f883e","user50","user50@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));



        Date time = sdf.parse("2020/3/25");
        List<ScenicScore> sp = new ArrayList<>();
        for (int i = 0; i < userlist.size(); i++) {
            if(i <= 24){
                for (int j = 0; j < 30; j++) {
                    ScenicScore scenicScore = new ScenicScore();
                    double score = 1.0;
                    int scenicnum = (int)(Math.random()*68);
                    if((scenicnum>=0&&scenicnum<=30) || (scenicnum>=48&&scenicnum<=53)){
                        score = (double)(int)(Math.random()*2+4);
                    }else{
                        score = (double)(int)(Math.random()*3+1);
                    }
                    scenicScore.setUserid(userlist.get(i).getUserid());
                    scenicScore.setScenicid(scenicnum+1);
                    scenicScore.setScore(score);
                    scenicScore.setTime(time);
                    sp.add(scenicScore);
                }
            }else{
                for (int j = 0; j < 30; j++) {
                    ScenicScore scenicScore = new ScenicScore();
                    double score = 1.0;
                    int scenicnum = (int)(Math.random()*68);
                    if((scenicnum>=31&&scenicnum<=47) || (scenicnum>=54&&scenicnum<=67)){
                        score = (double)(int)(Math.random()*2+4);
                    }else{
                        score = (double)(int)(Math.random()*3+1);
                    }
                    scenicScore.setUserid(userlist.get(i).getUserid());
                    scenicScore.setScenicid(scenicnum+1);
                    scenicScore.setScore(score);
                    scenicScore.setTime(time);
                    sp.add(scenicScore);
                }
            }
        }
        for (ScenicScore scenicScore : sp) {
//            System.out.println(scenicScore.getUserid()+","+ scenicScore.getScenicid()+","
//                    + scenicScore.getScore().intValue()+","+ scenicScore.getTime().getTime()+" 景点名字："+scenicslist.get(scenicScore.getScenicid()-1).getName());
            System.out.println(scenicScore.getUserid()+","+ scenicScore.getScenicid()+","+ scenicScore.getScore().intValue());
        }

        recommendService.batchInsert(sp);
    }

    @Test
    public void test2(){
        List<Scenic> scenicslist = new ArrayList<>();
        //主题：自然山水，沙滩海岸，主题乐园，田园风光，名胜古迹
        scenicslist.add(new Scenic(1,"漓江轻舟游","自然山水","桂林","特征略","image/scenic/pic/漓江游.jpg",0));
        scenicslist.add(new Scenic(2,"象山景区","自然山水","桂林","特征略","image/scenic/pic/象山景区.jpg",0));
        scenicslist.add(new Scenic(3,"遇龙河漂流","自然山水","桂林","特征略","image/scenic/pic/象山景区.jpg",0));
        scenicslist.add(new Scenic(4,"银子岩","自然山水","桂林","特征略","image/scenic/pic/银子岩.jpg",0));
        scenicslist.add(new Scenic(5,"四湖轻舟游","自然山水","桂林","特征略","image/scenic/pic/四湖轻舟游.jpg",0));
        scenicslist.add(new Scenic(6,"八寨沟","自然山水","钦州","特征略","image/scenic/pic/八寨沟.jpg",0));
        scenicslist.add(new Scenic(7,"龙潭国家森林公园","自然山水","贵港","特征略","image/scenic/pic/龙潭国家森林公园.jpg",0));
        scenicslist.add(new Scenic(8,"东兴屏峰雨林公园","自然山水","防城港","特征略","image/scenic/pic/东兴屏峰雨林公园.jpg",0));
        scenicslist.add(new Scenic(9,"铜石岭","自然山水","玉林","特征略","image/scenic/pic/铜石岭.jpg",0));
        scenicslist.add(new Scenic(10,"勾漏洞","自然山水","玉林","特征略","image/scenic/pic/勾漏洞.jpg",0));
        scenicslist.add(new Scenic(11,"大容山森林公园","自然山水","玉林","特征略","image/scenic/pic/大容山森林公园.jpg",0));
        scenicslist.add(new Scenic(12,"七百弄国家地质公园","自然山水","河池","特征略","image/scenic/pic/七百弄国家地质公园.jpg",0));
        scenicslist.add(new Scenic(13,"巴马水晶宫","自然山水","河池","特征略","image/scenic/pic/巴马水晶宫.jpg",0));
        scenicslist.add(new Scenic(14,"百魔洞","自然山水","河池","特征略","image/scenic/pic/百魔洞.jpg",0));
        scenicslist.add(new Scenic(15,"天龙顶国家山地公园","自然山水","梧州","特征略","image/scenic/pic/天龙顶国家山地公园.jpg",0));
        scenicslist.add(new Scenic(16,"大石围天坑群","自然山水","百色","特征略","image/scenic/pic/大石围天坑群.jpg",0));
        scenicslist.add(new Scenic(17,"德天瀑布景区","自然山水","崇左","特征略","image/scenic/pic/德天瀑布景区.jpg",0));
        scenicslist.add(new Scenic(18,"通灵大峡谷","自然山水","百色","特征略","image/scenic/pic/通灵大峡谷.jpg",0));
        scenicslist.add(new Scenic(19,"鹅泉","自然山水","百色","特征略","image/scenic/pic/鹅泉.jpg",0));
        scenicslist.add(new Scenic(20,"古龙山大峡谷","自然山水","百色","特征略","image/scenic/pic/古龙山大峡谷.jpg",0));
        scenicslist.add(new Scenic(21,"姑婆山","自然山水","贺州","特征略","image/scenic/pic/姑婆山.jpg",0));
        scenicslist.add(new Scenic(22,"玉石林风景区","自然山水","贺州","特征略","image/scenic/pic/玉石林风景区.jpg",0));
        scenicslist.add(new Scenic(23,"紫云洞景区","自然山水","贺州","特征略","image/scenic/pic/紫云洞景区.jpg",0));
        scenicslist.add(new Scenic(24,"石门仙湖景区","自然山水","柳州","特征略","image/scenic/pic/石门仙湖景区.jpg",0));
        scenicslist.add(new Scenic(25,"丹洲景区","自然山水","柳州","特征略","image/scenic/pic/龙虎山风景区.jpg",0));
        scenicslist.add(new Scenic(26,"龙虎山风景区","自然山水","南宁","特征略","image/scenic/pic/龙虎山风景区.jpg",0));
        scenicslist.add(new Scenic(27,"龙潭公园","自然山水","柳州","特征略","image/scenic/pic/龙潭公园.jpg",0));
        scenicslist.add(new Scenic(28,"金海湾红树林生态旅游区","自然山水","北海","特征略","image/scenic/pic/北海金海湾红树林生态旅游区.jpg",0));
        scenicslist.add(new Scenic(29,"青秀山","自然山水","南宁","特征略","image/scenic/pic/青秀山.jpg",0));
        scenicslist.add(new Scenic(30,"大明山","自然山水","南宁","特征略","image/scenic/pic/大明山.jpg",0));
        scenicslist.add(new Scenic(31,"西山风景名胜区","自然山水","贵港","特征略","image/scenic/pic/西山风景名胜区.jpg",0));

        scenicslist.add(new Scenic(32,"涠洲岛","沙滩海岸","北海","特征略","image/scenic/pic/涠洲岛.jpg",0));
        scenicslist.add(new Scenic(33,"五彩滩","沙滩海岸","北海","特征略","image/scenic/pic/五彩滩.jpg",0));
        scenicslist.add(new Scenic(34,"滴水丹屏","沙滩海岸","北海","特征略","image/scenic/pic/滴水丹屏.jpg",0));
        scenicslist.add(new Scenic(35,"北海银滩旅游度假区","沙滩海岸","北海","特征略","image/scenic/pic/北海银滩旅游度假区.jpg",0));
        scenicslist.add(new Scenic(36,"万尾金滩","沙滩海岸","防城港","特征略","image/scenic/pic/万尾金滩.jpg",0));
        scenicslist.add(new Scenic(37,"白浪滩","沙滩海岸","防城港","特征略","image/scenic/pic/白浪滩.jpg",0));
        scenicslist.add(new Scenic(38,"江山半岛","沙滩海岸","防城港","特征略","image/scenic/pic/江山半岛.jpg",0));
        scenicslist.add(new Scenic(39,"三娘湾","沙滩海岸","钦州","特征略","image/scenic/pic/三娘湾.jpg",0));

        scenicslist.add(new Scenic(40,"北海海底世界","主题乐园","北海","特征略","image/scenic/pic/北海海底世界.jpg",0));
        scenicslist.add(new Scenic(41,"海洋之窗","主题乐园","北海","特征略","image/scenic/pic/海洋之窗.jpg",0));
        scenicslist.add(new Scenic(42,"南宁动物园","主题乐园","南宁","特征略","image/scenic/pic/南宁动物园.jpg",0));
        scenicslist.add(new Scenic(43,"柳州动物园","主题乐园","柳州","特征略","image/scenic/pic/柳州动物园.jpg",0));
        scenicslist.add(new Scenic(44,"瑶寨九龙潭漂流","主题乐园","防城港","特征略","image/scenic/pic/瑶寨九龙潭漂流.jpg",0));
        scenicslist.add(new Scenic(45,"十万大山温泉","主题乐园","防城港","特征略","image/scenic/pic/十万大山温泉.jpg",0));
        scenicslist.add(new Scenic(46,"贺州温泉","主题乐园","贺州","特征略","image/scenic/pic/贺州温泉.jpg",0));
        scenicslist.add(new Scenic(47,"龙谷湾恐龙公园","主题乐园","崇左","特征略","image/scenic/pic/龙谷湾恐龙公园.jpg",0));
        scenicslist.add(new Scenic(48,"青牛谷漂流","主题乐园","贵港","特征略","image/scenic/pic/青牛谷漂流.jpg",0));

        scenicslist.add(new Scenic(49,"象州古象温泉度假村","田园风光","来宾","特征略","image/scenic/pic/象州古象温泉度假村.jpg",0));
        scenicslist.add(new Scenic(50,"龙脊梯田","田园风光","桂林","特征略","image/scenic/pic/龙脊梯田.jpg",0));
        scenicslist.add(new Scenic(51,"世外桃源","田园风光","桂林","特征略","image/scenic/pic/世外桃源.jpg",0));
        scenicslist.add(new Scenic(52,"三江侗乡","田园风光","柳州","特征略","image/scenic/pic/三江侗乡.jpg",0));
        scenicslist.add(new Scenic(53,"明仕田园","田园风光","崇左","特征略","image/scenic/pic/明仕田园.jpg",0));
        scenicslist.add(new Scenic(54,"巴马长寿村","田园风光","河池","特征略","image/scenic/pic/ 巴马长寿村.jpg",0));

        scenicslist.add(new Scenic(55,"独秀峰","名胜古迹","桂林","特征略","image/scenic/pic/独秀峰.jpg",0));
        scenicslist.add(new Scenic(56,"兴坪古镇","名胜古迹","桂林","特征略","image/scenic/pic/兴坪古镇.jpg",0));
        scenicslist.add(new Scenic(57,"日月双塔","名胜古迹","桂林","特征略","image/scenic/pic/日月双塔.jpg",0));
        scenicslist.add(new Scenic(58,"广西民族博物馆","名胜古迹","南宁","特征略","image/scenic/pic/广西民族博物馆.jpg",0));
        scenicslist.add(new Scenic(59,"程阳八寨","名胜古迹","柳州","特征略","image/scenic/pic/程阳八寨.jpg",0));
        scenicslist.add(new Scenic(60,"柳侯公园","名胜古迹","柳州","特征略","image/scenic/pic/柳侯公园.jpg",0));
        scenicslist.add(new Scenic(61,"黄姚古镇","名胜古迹","贺州","特征略","image/scenic/pic/黄姚古镇.jpg",0));
        scenicslist.add(new Scenic(62,"百色起义纪念馆","名胜古迹","百色","特征略","image/scenic/pic/百色起义纪念馆.jpg",0));
        scenicslist.add(new Scenic(63,"凭祥友谊关","名胜古迹","崇左","特征略","image/scenic/pic/凭祥友谊关.jpg",0));
        scenicslist.add(new Scenic(64,"刘三姐故里景区","名胜古迹","河池","特征略","image/scenic/pic/刘三姐故里景区.jpg",0));
        scenicslist.add(new Scenic(65,"真武阁","名胜古迹","玉林","特征略","image/scenic/pic/真武阁.jpg",0));
        scenicslist.add(new Scenic(66,"云天宫","名胜古迹","玉林","特征略","image/scenic/pic/云天宫.jpg",0));
        scenicslist.add(new Scenic(67,"灵渠","名胜古迹","桂林","特征略","image/scenic/pic/灵渠.jpg",0));
        scenicslist.add(new Scenic(68,"太平天国金田起义旧址","名胜古迹","贵港","特征略","image/scenic/pic/太平天国金田起义旧址.jpg",0));

        scenicService.batchScenic(scenicslist);
    }

    @Test
    public void test3() throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date birthday = sdf.parse("2000/1/1");
        List<User> userlist = new ArrayList<>();
        userlist.add(new User(1,"user1","e10adc3949ba59abbe56e057f20f883e","user1","user1@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(2,"user2","e10adc3949ba59abbe56e057f20f883e","user2","user2@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(3,"user3","e10adc3949ba59abbe56e057f20f883e","user3","user3@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(4,"user4","e10adc3949ba59abbe56e057f20f883e","user4","user4@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(5,"user5","e10adc3949ba59abbe56e057f20f883e","user5","user5@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(6,"user6","e10adc3949ba59abbe56e057f20f883e","user6","user6@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(7,"user7","e10adc3949ba59abbe56e057f20f883e","user7","user7@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(8,"user8","e10adc3949ba59abbe56e057f20f883e","user8","user8@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(9,"user9","e10adc3949ba59abbe56e057f20f883e","user9","user9@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(10,"user10","e10adc3949ba59abbe56e057f20f883e","user10","user10@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(11,"user11","e10adc3949ba59abbe56e057f20f883e","user11","user11@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(12,"user12","e10adc3949ba59abbe56e057f20f883e","user12","user12@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(13,"user13","e10adc3949ba59abbe56e057f20f883e","user13","user13@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(14,"user14","e10adc3949ba59abbe56e057f20f883e","user14","user14@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(15,"user15","e10adc3949ba59abbe56e057f20f883e","user15","user15@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(16,"user16","e10adc3949ba59abbe56e057f20f883e","user16","user16@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(17,"user17","e10adc3949ba59abbe56e057f20f883e","user17","user17@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(18,"user18","e10adc3949ba59abbe56e057f20f883e","user18","user18@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(19,"user19","e10adc3949ba59abbe56e057f20f883e","user19","user19@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(20,"user20","e10adc3949ba59abbe56e057f20f883e","user20","user20@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(21,"user21","e10adc3949ba59abbe56e057f20f883e","user21","user21@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(22,"user22","e10adc3949ba59abbe56e057f20f883e","user22","user22@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(23,"user23","e10adc3949ba59abbe56e057f20f883e","user23","user23@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(24,"user24","e10adc3949ba59abbe56e057f20f883e","user24","user24@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(25,"user25","e10adc3949ba59abbe56e057f20f883e","user25","user25@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(26,"user26","e10adc3949ba59abbe56e057f20f883e","user26","user26@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(27,"user27","e10adc3949ba59abbe56e057f20f883e","user27","user27@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(28,"user28","e10adc3949ba59abbe56e057f20f883e","user28","user28@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(29,"user29","e10adc3949ba59abbe56e057f20f883e","user29","user29@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(30,"user30","e10adc3949ba59abbe56e057f20f883e","user30","user30@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(31,"user31","e10adc3949ba59abbe56e057f20f883e","user31","user31@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(32,"user32","e10adc3949ba59abbe56e057f20f883e","user32","user32@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(33,"user33","e10adc3949ba59abbe56e057f20f883e","user33","user33@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(34,"user34","e10adc3949ba59abbe56e057f20f883e","user34","user34@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(35,"user35","e10adc3949ba59abbe56e057f20f883e","user35","user35@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(36,"user36","e10adc3949ba59abbe56e057f20f883e","user36","user36@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(37,"user37","e10adc3949ba59abbe56e057f20f883e","user37","user37@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(38,"user38","e10adc3949ba59abbe56e057f20f883e","user38","user38@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(39,"user39","e10adc3949ba59abbe56e057f20f883e","user39","user39@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(40,"user40","e10adc3949ba59abbe56e057f20f883e","user40","user40@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(41,"user41","e10adc3949ba59abbe56e057f20f883e","user41","user41@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(42,"user42","e10adc3949ba59abbe56e057f20f883e","user42","user42@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(43,"user43","e10adc3949ba59abbe56e057f20f883e","user43","user43@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(44,"user44","e10adc3949ba59abbe56e057f20f883e","user44","user44@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(45,"user45","e10adc3949ba59abbe56e057f20f883e","user45","user45@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(46,"user46","e10adc3949ba59abbe56e057f20f883e","user46","user46@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(47,"user47","e10adc3949ba59abbe56e057f20f883e","user47","user47@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(48,"user48","e10adc3949ba59abbe56e057f20f883e","user48","user48@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(49,"user49","e10adc3949ba59abbe56e057f20f883e","user49","user49@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));
        userlist.add(new User(50,"user50","e10adc3949ba59abbe56e057f20f883e","user50","user50@qq.com","13253472367",birthday,"male",1,"b71618d0-17e2-4ab0-8b61-28b2d0c76963"));

        userService.batchUser(userlist);
    }

    @Test
    public void test4() throws Exception{
        List<Scenic> scenicList = new ArrayList<>();
        scenicList = recommendService.recommendScenicForUser(1l,40);
        if(scenicList == null){
            System.out.println("用户尚未评分");
            return;
        }
        for (Scenic scenic : scenicList) {
            System.out.println(scenic.getId() + " " + scenic.getName()
                    + " " + scenic.getTheme() + " " + scenic.getPrediction());
        }
    }
    @Test
    public void test5() throws Exception{
        List<ScenicScore> scenicScoreList = new ArrayList<>();
        scenicScoreList = recommendService.selectScenicScoreList();
        ExportUtil.exportScenicScore(scenicScoreList);
    }

    @Test
    public void test6() throws Exception{
        ScenicScore scenicScore = new ScenicScore(50, 46, 5.0, new Date());
        int i = recommendService.changeScenicScore(scenicScore);
        System.out.println(i);
    }

    @Test
    public void test7() throws Exception{
        //一年=31536000000l 30天=2592000000毫秒 7天=604800000毫秒
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        long time = System.currentTimeMillis();
        long btime = time - 31536000000l;
        Date date = new Date(btime);
        String d = sdf.format(date);
        System.out.println(d);
        //System.out.println(sdf.parse("2020/04/02").getTime());

    }

    @Test
    public void test8() throws Exception{
        MyUserBasedRecommender mubr = new MyUserBasedRecommender();
        //拿到推荐的电影
        //mubr.userBasedRecommender(30,10);

    }

    @Test
    public void test9() throws Exception{

        List<Statistic> statisticList = recommendService.selectCountByTheme("2020-03-01", "2020-06-30");
        for (Statistic statistic : statisticList) {
            System.out.println(statistic.getTheme() + ":" +statistic.getNum());
        }
    }

    @Test
    public void test10() throws Exception{

        List<Scenic> scenicList = scenicService.selectScenicList();
        GetSimilarItem similarItem = new GetSimilarItem();
        similarItem.getSimilarItem(1, scenicList);
    }

    @Test
    public void test11() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date time = sdf.parse("2020/04/20");
        List<Scenic> scenicList = scenicService.selectScenicList2();
        List<User> userList = userService.selectUserList();
        List<ScenicScore> sp = new ArrayList<>();
        for (int i = 0; i < userList.size() - 2; i++) {
            if (i <= 24) {
                for (int j = 0; j < 25; j++) {
                    ScenicScore scenicScore = new ScenicScore();
                    double score = 1.0;
                    int flag = 1;
                    int scenicnum = 0;
                    while (flag == 1) {
                        flag = 0;
                        scenicnum = (int) (Math.random() * 68);
                        for (int k = 0; k < sp.size(); k++) {
                            if (sp.get(k).getUserid() == userList.get(i).getUserid() && sp.get(k).getScenicid() == scenicnum + 1) {
                                flag = 1;
                                continue;
                            }
                        }
                    }
                    if (scenicList.get(scenicnum).getTheme().equals("自然山水") || scenicList.get(scenicnum).getTheme().equals("田园风光")) {
                        score = (double) (int) (Math.random() * 2 + 4);
                    } else {
                        score = (double) (int) (Math.random() * 3 + 1);
                    }
                    scenicScore.setUserid(userList.get(i).getUserid());
                    scenicScore.setScenicid(scenicnum + 1);
                    scenicScore.setScore(score);
                    scenicScore.setTime(time);
                    sp.add(scenicScore);
                }
            } else {
                for (int j = 0; j < 35; j++) {
                    ScenicScore scenicScore = new ScenicScore();
                    double score = 1.0;
                    int flag = 1;
                    int scenicnum = 0;
                    while (flag == 1) {
                        flag = 0;
                        scenicnum = (int) (Math.random() * 68);
                        for (int k = 0; k < sp.size(); k++) {
                            if (sp.get(k).getUserid() == userList.get(i).getUserid() && sp.get(k).getScenicid() == scenicnum + 1) {
                                flag = 1;
                                continue;
                            }
                        }
                    }
                    if (scenicList.get(scenicnum).getTheme().equals("自然山水") || scenicList.get(scenicnum).getTheme().equals("田园风光")) {
                        score = (double) (int) (Math.random() * 3 + 1);
                    } else {
                        score = (double) (int) (Math.random() * 2 + 4);
                    }
                    scenicScore.setUserid(userList.get(i).getUserid());
                    scenicScore.setScenicid(scenicnum + 1);
                    scenicScore.setScore(score);
                    scenicScore.setTime(time);
                    sp.add(scenicScore);
                }
            }
        }
        System.out.println(sp.size());
        for (ScenicScore scenicScore : sp) {
            System.out.println(scenicScore.getUserid() +" "+ scenicScore.getScenicid() +" "+ scenicScore.getScore() +" "+ scenicScore.getTime()
                    +" "+ scenicList.get(scenicScore.getScenicid()-1).getName() +" "+ scenicList.get(scenicScore.getScenicid()-1).getTheme());
        }

        //recommendService.batchInsert(sp);
    }


}
