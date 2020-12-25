package com.qf.controller;


import com.qf.pojo.QueryVo;
import com.qf.pojo.Speaker;
import com.qf.service.SpeakerService;
import com.qf.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//茹东杰
@Controller
@RequestMapping("/speaker")
public class SpeakerController {
    @Autowired
    private SpeakerService speakerService;
    //茹东杰
    @RequestMapping("/showSpeakerList")
    public String showSpeakerList(QueryVo queryVo, Model model) {
        model.addAttribute("queryVo", queryVo);
        Page<Speaker> page = speakerService.selectSpeakerByQueryVo(queryVo);
        model.addAttribute("page", page);
        return "/behind/speakerList";
    }

    //茹东杰
    @RequestMapping("/saveOrUpdate")
    public String UpdateSpeaker(Speaker speaker) {
        if (speaker.getId() == null) {
            speakerService.addSeaker(speaker);
        } else {
            speakerService.UpdateSpeaker(speaker);
        }
        return "redirect:showSpeakerList";
    }
    //茹东杰
    @RequestMapping("/edit")
    public String edit(String id, Model model) {
        System.out.println(id + "：测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试");
        Speaker speaker = speakerService.selectById(id);

        model.addAttribute("speaker", speaker);
        return "/behind/addSpeaker";
    }
    //茹东杰
    @ResponseBody
    @RequestMapping("/speakerDel")
    public String speakerDel(String id) {
        if (speakerService.delById(id)) {
            return "success";
        } else {
            return "failing";
        }

    }
    //茹东杰
    @RequestMapping("/addSpeaker")
    public String addSpeaker() {
        return "/behind/addSpeaker";
    }

//    @RequestMapping("/addSpeaker")
//    public String add(Speaker speaker) {
//        speakerService.addSeaker(speaker);
//
//        return "/behind/addSpeaker";
//    }
}
