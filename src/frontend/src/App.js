import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import CourseDetails from "./Components/CourseDetails";
import CreateCourse from "./Components/CreateCourse";
import Home from "./Components/Home";
import UpdateCourse from "./Components/UpdateCourse";

export default ()=>{





  return(
    <>

      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/details" element={<CourseDetails />} />
          <Route path="/update" element={<UpdateCourse />} />
          <Route path="/create-course" element={<CreateCourse />} />
        </Routes>
      
      
      </BrowserRouter>


    </>
  )
}