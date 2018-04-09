/*************************************************************************
 *                  HONGLING CAPITAL CONFIDENTIAL AND PROPRIETARY
 *
 *                COPYRIGHT (C) HONGLING CAPITAL CORPORATION 2012
 *    ALL RIGHTS RESERVED BY HONGLING CAPITAL CORPORATION. THIS PROGRAM
 * MUST BE USED  SOLELY FOR THE PURPOSE FOR WHICH IT WAS FURNISHED BY
 * HONGLING CAPITAL CORPORATION. NO PART OF THIS PROGRAM MAY BE REPRODUCED
 * OR DISCLOSED TO OTHERS,IN ANY FORM, WITHOUT THE PRIOR WRITTEN
 * PERMISSION OF HONGLING CAPITAL CORPORATION. USE OF COPYRIGHT NOTICE
 * DOES NOT EVIDENCE PUBLICATION OF THE PROGRAM.
 *                  HONGLING CAPITAL CONFIDENTIAL AND PROPRIETARY
 *************************************************************************/
package com.github.xc145214.service.impl;

import com.github.xc145214.common.bean.JsonResult;
import com.github.xc145214.domain.mapper.UserMapper;
import com.github.xc145214.domain.repo.User;
import com.github.xc145214.service.UserService;
import com.github.xc145214.service.transaction.UserTranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author xiachuan at 2017/12/6 14:33。
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserTranService userTranService;

    @Override
    public JsonResult createUser(User user) {
        try {
            userTranService.create(user);
        } catch (Exception e) {
            return JsonResult.failed(e.getMessage());
        }
        return JsonResult.success();
    }

    @Override
    public String deleteBy(Long id) {
        try {
            userTranService.delete(id);
        } catch (Exception e) {
            return "Failed!";
        }
        return "success";
    }

    @Override
    public String updateUser(User user) {
        try {
            userTranService.updateUser(user);
        } catch (Exception e) {
            return "Failed!";
        }
        return "success";
    }

    @Override
    public List<User> getAll() {
        return userMapper.findAll();
    }

    @Override
    public List<User> getPageListBy(Integer start, Integer limit) {
        return userMapper.findPageBy(start,limit);
    }
}

