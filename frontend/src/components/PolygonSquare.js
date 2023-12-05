import "../styles/PolygonSquare.css";

export default function PolygonSquare(props) {
    console.log(props.id)
    return <div className={`polygon id-${props.id} ${props.color}`} id={props.properId} onClick={props.handleClick}> </div>

    // return(
    //     // <svg className={`polygon ${props.color}`} viewBox="0 0 100 100" >
    //     //     <polygon id={props.id} points={props.points} onClick={props.handleClick}/>
    //     // </svg>
    //     // <div className={`polygon ${props.color}`} style={{transform: `${props.skew} ${props.transform}`}} id={props.id} onClick={props.handleClick}> </div>
        
    // );
}
