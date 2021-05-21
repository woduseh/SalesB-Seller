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
package handong.capstone2019s.salesb.app.login;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
/* @RequestMapping("/login") */
public class LoginController {

    /**
     * Shows the login view.
     * @return
     */
    @RequestMapping("/login")
    public String sellerloginForm() {
        return "login/seller";
    }
    @RequestMapping("/sellerloginToMenu")
    public String sellerLogin(HttpSession session, Principal principal) {
    	ModelAndView mv = new ModelAndView();
    	if(session != null){
    		session.setAttribute("sellerCode", principal.getName());
    		mv.setViewName("menu/sellermain");
    		mv.addObject("sellerCode", "sellermain.jsp");
    	}
    	return "menu/sellermain";
    }    		
}
