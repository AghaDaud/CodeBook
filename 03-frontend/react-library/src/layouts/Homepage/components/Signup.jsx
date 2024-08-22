import React, { useRef,useState } from "react";
import emailjs from "@emailjs/browser";
import styled from "styled-components";
import { Button, Modal } from "react-bootstrap";

// npm i @emailjs/browser

const Signup = () => {
  
  const form = useRef();
const [showModal, setShowModal] = useState(false);

  const sendEmail = (e) => {
    e.preventDefault();

    emailjs
      .sendForm(
        "service_r7n438i",
        "template_jx351i9",
        form.current,
        "Qjx5uSEyyGR6q7GKY"
      )
      .then(
        (result) => {
          console.log(result.text);
          console.log("message sent");
          setShowModal(true);
        },
        (error) => {
          console.log(error.text);
        }
      );
  };

  return (
    <div className="col-4 col-md-4 container-fluid py-5  container d-flex justify-content-center align-items-center">
    <StyledContactForm>
      
      
      <h2>Sign Up</h2>
      <form ref={form} onSubmit={sendEmail}>

        <label>First Name</label>
        <input type="text" name="first_name" required/>
        <label>Last Name</label>
        <input type="text" name="last_name" required/>
        <label>UserName</label>
        <input type="email" name="user_name" required/>
        <label>Primary Email</label>
        <input type="email" name="user_email" required/>
        <label>Password</label>
        <input type="password" name="user_password" required/>
        <input type="submit" value="Send" />
      </form>
      <Modal show={showModal} onHide={() => setShowModal(false)}>
        <Modal.Header closeButton>
          <Modal.Title>Email Sent</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          Thank you for signing up! An email has been sent with your details.
        </Modal.Body>
        <Modal.Footer>
          <Button variant="primary" onClick={() => setShowModal(false)}>
            Close
          </Button>
        </Modal.Footer>
      </Modal>
    </StyledContactForm>
    </div>
  );
};

export default Signup

// Styles
const StyledContactForm = styled.div`
  width: 400px;
  form {
    display: flex;
    align-items: flex-start;
    flex-direction: column;
    width: 100%;
    font-size: 22px;
    input {
      width: 100%;
      height: 35px;
      padding: 7px;
      outline: none;
      border-radius: 5px;
      border: 1px solid rgb(220, 220, 220);
      &:focus {
        border: 2px solid rgba(0, 206, 158, 1);
      }
    }
    textarea {
      max-width: 100%;
      min-width: 100%;
      width: 100%;
      max-height: 100px;
      min-height: 100px;
      padding: 7px;
      outline: none;
      border-radius: 5px;
      border: 1px solid rgb(220, 220, 220);
      &:focus {
        border: 2px solid rgba(0, 206, 158, 1);
      }
    }
    label {
      margin-top: 1rem;
    }
    input[type="submit"] {
      margin-top: 2rem;
      cursor: pointer;
      background: rgb(249, 105, 14);
      color: white;
      border: none;
      height: 50px
    }
  }
`;































// import React, { useState } from 'react';

// const Signup = () => {
//   const [formData, setFormData] = useState({
//     name: '',
//     email: '',
//     password: '',
//     number: ''
//   });



//   const handleChange = (e) => {
//     setFormData({ ...formData, [e.target.name]: e.target.value });
//   };

//   const handleSubmit = async (e) => {
//     e.preventDefault();

    

    

//   return (
//     <div>
//       <h2>Signup Form</h2>
//       <form onSubmit={handleSubmit}>
//         <label>
//           Name:
//           <input type="text" name="name" value={formData.name} onChange={handleChange} required />
//         </label>
//         <br />
//         <label>
//           Email:
//           <input type="email" name="email" value={formData.email} onChange={handleChange} required />
//         </label>
//         <br />
//         <label>
//           Password:
//           <input type="password" name="password" value={formData.password} onChange={handleChange} required />
//         </label>
//         <br />
//         <label>
//           Number:
//           <input type="tel" name="number" value={formData.number} onChange={handleChange} required />
//         </label>
//         <br />
//         <button type="submit">Submit</button>
//       </form>
//     </div>
//   );
// };
// }
// export default Signup;