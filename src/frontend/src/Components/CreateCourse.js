import React from "react";
import { useNavigate } from "react-router-dom";


export default function CreateCourse(){

    const navigate = useNavigate();

    let goBackHome = ()=>{

        navigate("/");
    }



    return (
      <>
        <nav className="navbar navbar-expand-lg ">
            <div class="container-fluid">
                <h1 className="bigTitle" onClick={goBackHome}>Courses</h1>
                <p className="welcome">Welcome Andrei !</p>
                <p className="signOut">Sign out</p>
            </div>
        </nav>

        <form className="create">
        <fieldset className="box1">
            <legend>Create Course</legend>
            <div class="form-group ">
            <label for="staticEmail" class="form-label">Course Title</label>
            <div >
                <input type="text" className="title" />
            </div>
            </div>

            <div class="form-group">
            <label for="exampleTextarea" class="form-label">Course Description</label>
            <textarea class="form-control" id="exampleTextarea" ></textarea>
            </div>
        </fieldset>

        <fieldset className="box2">
           
            <div class="form-group row">
            <label for="staticEmail" class="form-label">Estimated Time</label>
            <div >
                <input type="text" className="title" />
            </div>
            </div>

            <div class="form-group">
            <label for="exampleTextarea" class="form-label">Materials Needed</label>
            <textarea class="form-control" id="exampleTextarea" ></textarea>
            </div>
        </fieldset>
   
   
        <section className="buttonSection">

            <button className="create-btn">Create Course</button>
            <button className="cancel-btn">Cancel</button>


        </section>
        
      
      
    
    
 
    
 
</form>
      
      </>






    )
}