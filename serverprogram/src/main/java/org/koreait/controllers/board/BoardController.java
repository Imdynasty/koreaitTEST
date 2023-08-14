package org.koreait.controllers.board;

import lombok.RequiredArgsConstructor;
import org.koreait.models.board.BoardData;
import org.koreait.models.board.InfoService;
import org.koreait.models.board.SaveService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final InfoService infoService;
    private final SaveService saveService;

    @GetMapping("/write")
    public String write(@ModelAttribute DataForm data){//사용자 전달값을 핸들러 매개변수 매핑
        return "board/write";
    }
    @PostMapping("/save")
    public String save(DataForm data, Errors error){//@Valid data 유효성검사{
        if(error.hasErrors()){
            return "board/write";
        }
        saveService.save(data);

        return "redirect:/board/view/" + data.getId();
    }

    @GetMapping("/view/{id}")//getmapping 경로에서 @PathVariable id 찾아서 변수로 사용
    public String view(@PathVariable long id, Model model){//Model : view로 연결해주는 스프링 객체
        BoardData data = infoService.get(id);

        model.addAttribute("data", data);//data자료 넘기기

        return "board/view";
    }

    @ExceptionHandler(RuntimeException.class)//에러시 알림
    public String errorHandler(RuntimeException e, Model model){
        String script = String.format("alert('%s');history.back();", e.getMessage());
        model.addAttribute("script",script);
        e.printStackTrace();
        return "commons/execute";
    }
}
