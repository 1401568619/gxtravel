package com.gxtravel.utils;

import com.gxtravel.entity.ScenicScore;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportUtil {
    public static void exportScenicScore(List<ScenicScore> scenicScoreList) throws IOException {
        String path = "F:\\dev\\ideaspace\\gxtravel\\src\\main\\resources\\scenicscore.txt";
        File file = new File(path);
        if(file.exists()){
            file.delete();
            file.createNewFile();
        }else{
            file.createNewFile();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        for (ScenicScore scenicScore : scenicScoreList) {
            String line = scenicScore.getUserid() + "," + scenicScore.getScenicid() + "," + scenicScore.getScore().intValue();
            bw.write(line);
            bw.newLine();
        }
        bw.close();

    }
}
