import Board from "../components/Board";
import Historytable from "../components/HistoryTable";

export default function Game() {
    return(
        <>
            <Board/>
            <Historytable moves={["e11","e9", "e8", "e7", "e11","e9", "e8", "e7", "e11","e9", "e8", "e7", "e11","e9", "e8", "e7", "e11","e9", "e8", "e7", "e11","e9", "e8", "e7", "e11","e9", "e8", "e7", "e11","e9", "e8", "e7", "e11","e9", "e8", "e7", "e11","e9", "e8", "e7", "e11","e9", "e8", "e7", "e11","e9", "e8", "e7", "e11","e9", "e8", "e7"]}/>
        </>
    );
}