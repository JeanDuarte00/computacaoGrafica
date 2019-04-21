package miniGame.model.score;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreData {

    String fileName = "C:\\Users\\jean_\\IdeaProjects\\computacaoGrafica\\src\\miniGame\\scoreData\\score.txt";

    public void saveScore(Score scoreData) {

        Gson gson = new Gson();
        String jsonFile = "";
        try {
        File arquivo = new File(this.fileName);
        FileReader fr = new FileReader(arquivo);
        BufferedReader br = new BufferedReader(fr);
        while( br.ready() ){
            jsonFile += br.readLine();
        }
        List<Score> listScore = toObjectList(jsonFile, Score.class);
        listScore.add(scoreData);
        Collections.sort(listScore);
        arquivo.delete();

        FileWriter fw = new FileWriter( this.fileName);
        fw.write(gson.toJson(listScore));
        br.close();
        fr.close();
        fw.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean newRecord(int score)  {
        Gson gson;
        gson = new Gson();
        String jsonFile = "";
        FileReader fr = null;
        try {
            File arquivo = new File(this.fileName);
            fr = new FileReader(arquivo);

            BufferedReader br = new BufferedReader(fr);
            while( br.ready() ){
                jsonFile += br.readLine();
            }
            List<Score> listScore = toObjectList(jsonFile, Score.class);
             br.close();
            fr.close();
            return listScore.get(0).getScore()<score;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<Score> getTopFiveScores() {
        Gson gson = new Gson();
        String jsonFile = "";
        try {
        File arquivo = new File(this.fileName);
        FileReader fr = new FileReader(arquivo);
        BufferedReader br = new BufferedReader(fr);
            while( br.ready() ){
                jsonFile += br.readLine();
            }
        List<Score> listScore = toObjectList(jsonFile, Score.class);
        br.close();

            fr.close();
            return listScore.subList(0,5);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private <T> List<T> toObjectList(String json, Class<T> clazz) {
        Gson gson = new Gson();
        if(json == null){
            return null;
        }

        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(json).getAsJsonArray();

        List<T> list = new ArrayList<T>();
        for (final JsonElement jsonElement : array) {
            T entity = gson.fromJson(jsonElement, clazz);
            list.add(entity);
        }
        return list;
    }
}
