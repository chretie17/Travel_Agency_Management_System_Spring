
Travel Agency Application - Project Overview

Purpose:

The Travel Agency Application is a comprehensive platform designed to offer users a seamless and engaging experience in planning, exploring, and booking tours through a travel agency. This application brings together an intuitive frontend interface and robust backend services to elevate the overall travel booking process.
Homepage:
 
 ![image](https://github.com/chretie17/Travel_Agency_Management_System_Spring/assets/130080990/8963c4b5-98d5-4225-8591-70faad26a81e)

My Database Design
![image](https://github.com/chretie17/Travel_Agency_Management_System_Spring/assets/130080990/dd9a6f13-61bc-4b46-9a9f-5055450147a3)

This is homepage for my application that have good user experience with good design

Expected Outcomes:

1. User Interaction:

- ContactService:
  - Users can submit inquiries and contact the travel agency for additional information or assistance.
    ![image](https://github.com/chretie17/Travel_Agency_Management_System_Spring/assets/130080990/e6b0c08b-0dc8-4414-a97d-f628331e17b6)

  - The ContactService handles form submissions and ensures the secure storage of user contact details.
    
  - The user gets an email that the form has been submitted successfully.
  - ![image](https://github.com/chretie17/Travel_Agency_Management_System_Spring/assets/130080990/890dd2a3-1e82-467f-9e19-abe1b4b21e1b)

 

- EmailService:
  - Confirmation emails are sent to users, providing a professional and reassuring touch to their interactions.
 
  - Password reset links are securely generated and delivered to users through email.
    ![image](https://github.com/chretie17/Travel_Agency_Management_System_Spring/assets/130080990/9de7afd7-af34-4f05-958f-7f4dcb67c22f)

 
  - Email verification is implemented for user contact, enhancing security and ensuring valid user information.
  - When a user makes an order he gets an email:
 ![image](https://github.com/chretie17/Travel_Agency_Management_System_Spring/assets/130080990/bdda7f26-6323-41ae-91d5-fa3c0005f1ff)

  - Email is sent when the user sign up.
    ![image](https://github.com/chretie17/Travel_Agency_Management_System_Spring/assets/130080990/d1e2c7f1-4bcb-4d59-85c4-aa033cb8e566)


## 2. Tour Booking:

- OrderService:
  - Users can book Tours, allowing them to book multiple tours in a single transaction.
 
 ![image](https://github.com/chretie17/Travel_Agency_Management_System_Spring/assets/130080990/b14d0709-bc78-42b2-ab0f-ca384557594d)

  - The application manages the storage and retrieval of order information, ensuring a smooth booking experience.
  ![image](https://github.com/chretie17/Travel_Agency_Management_System_Spring/assets/130080990/436d7e43-c8be-4a7a-9dc6-cc194abf0dc5)


## 3. User Management:

- **UserService:**
  - User registration is facilitated with secure password encryption.
 ![image](https://github.com/chretie17/Travel_Agency_Management_System_Spring/assets/130080990/523ee412-565c-4264-8ade-40c88c2f5929)

  - The user gets an email after signing up.
 ![image](https://github.com/chretie17/Travel_Agency_Management_System_Spring/assets/130080990/70d4b782-1de4-4914-a983-35f13cf5438d)

  - Role-based access control is implemented to manage user privileges.
  - Users have specific roles, such as "ROLE_USER" and "ROLE_ADMIN," defining their access levels.


## - PasswordResetTokenService:
  - Users can initiate secure password resets through a token-based mechanism.
  - Scheduled token cleanup ensures the security and efficiency of the password reset process.

 ## 4. Tour Management:

- TourService:
  - Admins can efficiently manage tours, including adding, modifying, and deleting tour details.
  - The MyTours utility assists users in managing their selected tours during a session.
  - My orders assist the user to see the orders that he booked.

## 5. Admin 

- Admin manages everything that's related to the system.
 ![image](https://github.com/chretie17/Travel_Agency_Management_System_Spring/assets/130080990/776c029b-d68e-41d7-9157-fa7e1a7ba7e4)
![image](https://github.com/chretie17/Travel_Agency_Management_System_Spring/assets/130080990/958a9397-e989-4de4-837b-587aaa77c3da)

 
- Admin add tours delete, and update them.
 ![image](https://github.com/chretie17/Travel_Agency_Management_System_Spring/assets/130080990/58572861-d137-4153-bfd4-c5a8b57e8d8c)

 ![image](https://github.com/chretie17/Travel_Agency_Management_System_Spring/assets/130080990/9452ca28-edfe-4a10-9deb-a87d003a7827)

- Admin see Booked Tours and see who booked them.
  ![image](https://github.com/chretie17/Travel_Agency_Management_System_Spring/assets/130080990/f2869827-ffdc-43be-9402-a965327f8f51)

 
Constraints and Limitations:

1. Email Service:
   - The application relies on an external email service, such as SMTP, for sending transactional emails.

2. Token Cleanup:
   - A scheduled task in PasswordResetTokenService cleans up expired tokens every 24 hours.

3. Security:
   - User passwords adhere to specific criteria, ensuring high security.
   - Role-based access control enhances application security and user privacy.

4. Email Verification:
   - A secure email verification process is in place for user contact details.

Future Enhancements:

1. Payment Processing:
   - Integration with a secure payment gateway for processing tour bookings.

2. User Reviews:
   - Allow users to submit reviews and ratings for tours they have experienced.

3. Tour Availability:
   - Implement a feature to display tour availability based on specified dates.

Frontend Integration:

The application boasts a fully implemented frontend, providing users with an intuitive interface for:

- Exploring available tours.
- Submitting inquiries and receiving confirmation emails.
- Creating accounts and managing bookings effortlessly.

## Conclusion:

With a well-integrated frontend and backend solution, the Travel Agency Application emerges as a feature-rich platform, offering users a delightful and streamlined travel planning experience.


