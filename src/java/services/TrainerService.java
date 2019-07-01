/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.TrainerDao;
import entities.Trainer;
import java.util.List;

/**
 *
 * @author me
 */
public class TrainerService {
    
    public String getTrainers(){
        String result="";
        TrainerDao td = new TrainerDao();
        List<Trainer> trainers = td.getTrainersJPA();
        result +=("<!DOCTYPE html>");
        result +=("<html>");
        result +=("<head>");
        result +=("</head>");
        result +=("<body>");
        result +=("<h1>These are the trainers: </h1>");
        result +=("<br />");
        for(Trainer s:trainers) {
            String delete =" <a href='DeleteTrainer?delete="+s.getId()+"' onclick=\"return confirm('Are you sure?')\">Delete</a>";
            String update =" <a href='UpdateTrainer?update="+s.getId()+"'>Update</a>";
            result += "<p>"+s+delete+update+"</p>";    
        }
        String add =" <a href='InsertTrainer'>Add</a>";
        result += "<p>"+add+"</p>";
        result +=("</body>");
        result +=("</html>");
        return result;
    }
    
    public boolean updateTrainer(int id,Trainer tr){
        TrainerDao sd = new TrainerDao();       
        if(sd.updateTrainerJPA(id,tr))return true;    
        return false;
    }
    
    public boolean insertTrainer(Trainer tr){
        TrainerDao sd = new TrainerDao();       
        if(sd.insertTrainerJPA(tr))return true;    
        return false;
    }
    public boolean deleteTrainer(int id){
        TrainerDao td = new TrainerDao();       
        if(td.deleteTrainerJPA(id))return true;    
        return false;
    }
    
    public Trainer getTrainerByID(int id){
        TrainerDao td=new TrainerDao();
        return td.getTrainerById(id);
    }
}
