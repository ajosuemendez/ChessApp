package com.thechessnuts.InputHandlerService;

import com.thechessnuts.InputHandlerService.models.Square;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/square")
public class InputHandlerController{

    @RequestMapping("/{squareId}")
    public List<Square> getValidMoves(@PathVariable("squareId") String squareId) {

        return Collections.singletonList(
            new Square("E4", "white-pawn", false)
        );
    }
}