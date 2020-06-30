package com.gxtravel.utils;

import org.apache.mahout.cf.taste.common.NoSuchUserException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

import java.io.File;
import java.util.List;

public class MyItemBasedRecommender {

    public List<RecommendedItem> myItemBasedRecommender(long userID, int size){
        List<RecommendedItem> recommendations = null;
        try {
            DataModel model = new FileDataModel(new File("F:/dev/ideaspace/gxtravel/src/main/resources/scenicscore.txt"));//构造数据模型
            ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);//计算内容相似度
            Recommender recommender = new GenericItemBasedRecommender(model, similarity);//构造推荐引擎
            try{
                recommendations = recommender.recommend(userID, size);//得到推荐结果
            }catch(NoSuchUserException ex){
                return null;
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return recommendations;
    }
}
