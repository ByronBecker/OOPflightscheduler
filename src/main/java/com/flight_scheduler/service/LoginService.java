package com.flight_scheduler.service;
import com.flight_scheduler.model.*;

public interface LoginService{    
       public boolean checkLogin(String userName, String userPassword);
}