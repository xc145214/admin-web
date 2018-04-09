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
package com.github.xc145214.web;

import com.github.xc145214.common.bean.JsonResult;
import com.github.xc145214.domain.repo.User;
import com.github.xc145214.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xiachuan at 2017/12/6 14:36。
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> createUser(@ModelAttribute User user) {
         return ResponseEntity.ok( userService.createUser(user));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteBy(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public String updateUser(@ModelAttribute User user) {
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {
        return userService.getAll();
    }


    @RequestMapping(value = "/{start}/{limit}", method = RequestMethod.GET)
    public List<User> getUserList(@PathVariable Integer start, @PathVariable Integer limit) {
        return userService.getPageListBy(start, limit);
    }


}

