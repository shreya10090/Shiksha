Feature: Share your details to view number

  Background: 
    Given user is logged in on Shiksha application

  @personal_details
  Scenario Outline: Check the form to Share your personal details
    When user selects top mba colleges
    And click on write a review option
    And user enters <EmailID>, <Name> and <mobile>
    And selects <college>
    Then Click on next button

    Examples: 
      | EmailID               | Name   | mobile     |  | college         |
      | shrreyaa109@gmail.com | Shreya | 9340186719 |  | XLRI Jamshedpur |

  @Write_review
  Scenario: Check the form to Share your reviews
    When user sends rating, enters reviews for Placements
      | Outstanding placement opportunities! The college provides excellent career guidance and connects students with top-tier companies.The college provides excellent career guidance and connects students with top-tier companies. A springboard for success! |
    And user sends rating, enters reviews for Infrastructure
      | The college boasts impressive infrastructure with modern facilities. From state-of-the-art classrooms to well-equipped labs and recreational spaces, From state-of-the-art classrooms to well-equipped labs and recreational spaces, it offers a conducive environment for learning and growth. |
    And user sends rating, enters reviews for Faculty
      | The faculty at this college are highly knowledgeable and dedicated. They go above and beyond to ensure students grasp concepts thoroughly.. They go above and beyond to ensure students grasp concepts thoroughly. Their expertise and support foster an enriching learning experience. |
    And user sends rating for value for money and campus
      | 150000 |
    And user selects recommendation
    And user enters Title of Review
      | Exemplary Faculty: Nurturing Excellence |
    Then Click on second next button

  @More_Details
  Scenario Outline: Check the form to Share your more details
    When user enters <Linkedin> Profile
    And click on third next option

    Examples: 
      | Linkedin                                                           |
      | https://www.linkedin.com/?trk=guest_homepage-basic_nav-header-logo |

  @College_Life
  Scenario: check college life details
    When user gives college feedback
    Then form is submitted

  @Feedback_ReleventInfo
  Scenario Outline: check feedback with null value
    When user gives null feedback <feedback>
    Then form should not be submitted

    Examples: 
      | feedback |
      | ..       |
