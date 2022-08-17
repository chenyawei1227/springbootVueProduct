package com.example.springbootvueproduct.controller.book;

import com.example.springbootvueproduct.vo.BookVO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description:
 * @Author: Luck
 * @Date: 2022/8/16
 */
@Controller
public class BookController {

  @GetMapping("/books")
  public ModelAndView books(){
    List<BookVO> list = new ArrayList<>();
    BookVO bookVO = new BookVO();
    bookVO.setId("1");
    bookVO.setName("《百年孤独》");
    bookVO.setAuthor("哥伦比亚作家加西亚·马尔克斯");
    BookVO bookVO2 = new BookVO();
    bookVO2.setId("2");
    bookVO2.setName("《蛙》");
    bookVO2.setAuthor("莫言");
    list.add(bookVO);
    list.add(bookVO2);
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("books",list);
    modelAndView.setViewName("books");
    return modelAndView;
  }
}
