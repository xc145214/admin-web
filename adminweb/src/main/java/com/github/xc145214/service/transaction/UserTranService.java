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
package com.github.xc145214.service.transaction;

import com.github.xc145214.domain.mapper.UserMapper;
import com.github.xc145214.domain.repo.User;
import com.github.xc145214.common.exception.JdbcException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * XXXXXXXXXXXXXXXXXXXXX
 *
 * @author xiachuan at 2017/12/6 14:51。
 */
@Service
public class UserTranService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = JdbcException.class)
    public void create(User user){
        int result = userMapper.insert(user.getName(),user.getAge());
        if(result != 1){
            throw new JdbcException("insert User failed!");
        }
    }

    @Transactional(rollbackFor = JdbcException.class)
    public void delete(Long id){
        int result= userMapper.delete(id);
        if(result != 1){
            throw new JdbcException("delete User failed!");
        }
    }

    @Transactional(rollbackFor = JdbcException.class)
    public void updateUser(User user){
        int result =userMapper.update( user);
        if(result != 1){
            throw new JdbcException("update User failed!");
        }
    }

}

