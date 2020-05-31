package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;

public interface IUserService {
    ServerResponse<User> login (String name, String password);
    ServerResponse<String> register (User user);
    ServerResponse<String> checkVaild(String value,String type);
    ServerResponse<String> selectQuestion(String username);
    ServerResponse<String> checkAnswer(String username,String question,String answer);
    ServerResponse<String> forgetResetPassword(String username,String passwordNes, String forgetToke);
    ServerResponse<String> resetPassword(User user,String passwordOld,String passwordNew);
    ServerResponse<User> updateInformation(User user);
    ServerResponse<User> getInformation(Integer userId);
}
