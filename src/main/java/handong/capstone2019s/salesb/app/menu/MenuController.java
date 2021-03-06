/*
 * Copyright(c) 2013 NTT DATA Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package handong.capstone2019s.salesb.app.menu;

import lombok.extern.slf4j.Slf4j;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
@RequestMapping("/")
public class MenuController {

    /**
     * forward initial menu view.
     * @return menu view
     */
    @RequestMapping(value = "/{sellerCode}", method = RequestMethod.GET)
    public String haveSellerCode() {
        return "seller/form";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String init() {
        return "seller/form";
    }
}
