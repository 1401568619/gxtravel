package com.gxtravel.utils;

import com.gxtravel.entity.Scenic;
import org.apache.mahout.cf.taste.common.NoSuchUserException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GetSimilarItem {

    public  List<Scenic> getSimilarItem(long itemID, List<Scenic> scenicList){
        List<Scenic> similarScenic = new ArrayList<>();
        try {
            DataModel model = new FileDataModel(new File("F:/dev/ideaspace/gxtravel/src/main/resources/scenicscore.txt"));//构造数据模型
            ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);//计算内容相似度

            for (Scenic scenic : scenicList) {
                if(scenic.getId() != itemID){
                    //获得物品itemID与其他物品的相似度
                    double v = similarity.itemSimilarity(itemID, scenic.getId().longValue());
                    if(v > 0.9){
                        similarScenic.add(scenic);
                        System.out.println("物品 "+itemID+" 与物品 "+scenic.getId() + scenic.getName() +" 的相似度为： "+ v);
                    }
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return similarScenic;
    }
}
