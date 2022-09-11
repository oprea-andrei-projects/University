import React from "react";
import {useNavigate} from "react-router-dom"

export default function Home(){



    const navigate = useNavigate();

    let goBackHome = ()=>{

        navigate("/");
    }



    let handleCourseDetails = ()=>{


        navigate("/details")

    }

    let handleCourseUpdate = ()=>{

        navigate("/update")
    }

    let handleCreateCourse = ()=>{

        navigate("/create-course")
    }


    return (
        <>
          <nav class="navbar navbar-expand-lg ">
              <div class="container-fluid">
                  <h1 className="bigTitle" >Courses</h1>
                  <p className="welcome">Welcome Andrei !</p>
                  <p className="signOut">Sign out</p>
              </div>
          </nav>


           <section className="cardSection">

            <div className="cutie courseName" onClick={handleCourseDetails}>
                <p className="hTitle">Course</p>
                <p className="hDetail">Learn How To Program</p>


            </div>

          <div className="cutie courseDetail" onClick={handleCourseUpdate}>

                <p className="hTitle">Course</p>
                <p className="hDetail">iii</p>


          </div>

          <div className="cutie newCourse" onClick={handleCreateCourse}>

                <p className="hAddCourse">+New Course</p>

          </div>
            
            
            </section> 

         
  

        
        </>
  
  
  
  
  
  
      )
}