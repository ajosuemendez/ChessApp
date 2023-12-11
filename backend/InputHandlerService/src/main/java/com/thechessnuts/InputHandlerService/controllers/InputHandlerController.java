package com.thechessnuts.InputHandlerService;

import com.thechessnuts.InputHandlerService.models.Square;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


@RestController
@RequestMapping("/")
public class InputHandlerController{

    @RequestMapping("/gameId={gameId}")
    public List<Square> getValidMoves(@PathVariable("gameId") String gameId) {

        // return Collections.singletonList(
        //     new Square("E4", "white-pawn", false)
        // );

        List<Square> squareList = new ArrayList<Square>();
        squareList.add(new Square("E4", "white-pawn", false));
        squareList.add(new Square("E5", "white-pawn", false));
    
        return squareList;
    }
}