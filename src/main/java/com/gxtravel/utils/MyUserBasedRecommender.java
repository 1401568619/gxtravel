package com.gxtravel.utils;


import com.gxtravel.entity.User;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MyUserBasedRecommender {
	public List<User> getSimilarUser(long userID) {
		// step:1 构建模型 2 计算相似度 3 查找k紧邻 4 构造推荐引擎
		//List<RecommendedItem> recommendations = null;
		List<User> userList = new ArrayList<>();
		try {
			DataModel model = new FileDataModel(new File("F:/dev/ideaspace/gxtravel/src/main/resources/scenicscore.txt"));//构造数据模型
			UserSimilarity usersimilarity = new PearsonCorrelationSimilarity(model);//用PearsonCorrelation 算法计算用户相似度
			UserNeighborhood neighborhood = new NearestNUserNeighborhood(5, usersimilarity, model);//计算用户的“邻居”，这里根据指定数量计算。
			long[] userNeighborhood = neighborhood.getUserNeighborhood(userID);
			System.out.println("数量:"+userNeighborhood.length);
			for (long un : userNeighborhood) {
				//当前用户与其邻居的相似度
				double similarity = usersimilarity.userSimilarity(userID, un);
				User user = new User();
				user.setUserid((int)un);
				user.setSimilarity(similarity);
				userList.add(user);
				//System.out.println(l);
			}
			//Recommender recommender = new CachingRecommender(new GenericUserBasedRecommender(model, neighborhood, usersimilarity));//采用 CachingRecommender 为 RecommendationItem 进行缓存
			//recommendations = recommender.recommend(userID, size);//得到推荐的结果，size是推荐结果的数目
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

}