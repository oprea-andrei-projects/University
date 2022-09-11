import React from "react";
import { useNavigate } from "react-router-dom";


export default function CourseDetails(){


    const navigate = useNavigate();

    let goBackHome = ()=>{

        navigate("/");
    }

    return (
        <>
          <nav class="navbar navbar-expand-lg ">
              <div class="container-fluid">
                  <h1 className="bigTitle" onClick={goBackHome}>Courses</h1>
                  <p className="welcome">Welcome Andrei !</p>
                  <p className="signOut">Sign out</p>
              </div>
          </nav>


           


          <section className="buttonSection bs2">

            <button className="create-btn">Update Course</button>
            <button className="create-btn">Delete Course</button>
            <button className="cancel-btn">Return to List</button>


        </section>

        <section className="details">

            <h1>Course Detail</h1>

            <div className="course-detail-title">


                <h4>COURSE</h4>
            </div>
            <p>By Andrei</p>

            <div className="course-detail-title">


            <h4>ESTIMATED TIME</h4>
            </div>

            <div className="course-detail-title">


            <h4>MATERIALS NEEDED</h4>
            </div>




        </section>

         
  

        
        </>
  
  
  
  
  
  
      )
}