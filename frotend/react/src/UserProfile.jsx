const UserProfile=(props)=>{
    return (
        <div>
            <h1>{props.name}</h1>
            <p>{props.age}</p>
            <img src={`https://randomuser.me/api/portraits/${props.gender}/75.jpg`}/>
        </div>
    )
}
export default UserProfile;