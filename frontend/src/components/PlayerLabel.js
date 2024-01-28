import "../styles/PlayerLabel.css"

export default function PlayerLabel(props) {
    return(
        <span className={`generic-player-label label-${props.id}`}> {props.label + " " + props.name} </span>
    );
}