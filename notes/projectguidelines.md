Project Guidelines
===================

##Getting Started
Begin work on your projects by first cloning the Github project repository that the instructor has created for you. The name of the repository will be `<username>-project`, for example `srollins-project`. You must work from this starting point, and submit your code to the same repository. More detail is available here: [Github instructions](githubinstructions.md)


##Submission
Projects may be resubmitted until *mastery* is demonstrated, but beware that failure to make timely progress will likely result in a low or failing grade in the course.

Follow the [instructions for using Github](githubinstructions.md) to make sure you have uploaded your code correctly.

Use the Github website to make sure you see the latest version of your code there.

Create a new release of your project as described in the [instructions for using Github](githubinstructions.md#submission). Once you complete this step, the instructor and TA will receive an email triggering the verification process. 

:warning: You may submit at most one project per week. 

:warning:  Do not create a release until you are passing all tests and believe you are prepared for a code review. You may always seek early feedback on your code by visiting office hours.

##Testing
You should perform your own testing while you develop the project. The code provided only tests your final result, and may not be suitable for testing your project during development. To see which test files are relevant for each project, look at the test suites provided in the `Project#Test.java` files. 

###Running JUnit Tests Locally
If your Eclipse project is properly setup, you should be able to right-click the appropriate test file and select "Run As->JUnit Test" in the Package Explorer.

##Code Review
Once you have verified your project is properly submitted and passing the necessary JUnit tests, you may sign up for code review. Each code review is 15 minutes, and will be held in the instructor's office.

#### Code Review Appointments ####

Once the instructor and TA verify your code passes all tests and meets a minimum criteria for review, you will receive a link to sign up for a code review. Otherwise, you will need to figure out why your project is not passing the unit tests and repeat this process.

:memo: You can see all of the issues that you have created or have been assigned in the [Issues Dashboard](https://github.com/dashboard/issues/) on GitHub.

**:warning: If you sign up for code review but you are not passing the appropriate tests, your project score will be deducted 5 points.**

#### Code Review Process ####

During the code review, the instructor will discuss your code design with you and make suggestions for improvement. These will be provided either as `// TODO` comments directly in your code or as open "Issues" in GitHub. *You may remove these comments and close the issues after addressing them.*

After the review, your project will be given a `PASS`, `WARN`, or `FAIL` status:

- The `PASS` status signifies you passed the code review and may move on to the next project. Congratulations!

- The `WARN` status signifies you passed the code review and may move on to the next project, but must address some lingering issues before submitting the next project.

- The `FAIL` status signifies you did not pass the code review, and must resubmit. The resubmission process is outlined below.

  **:persevere: Do not fret!** This is expected to happen at least once per project. If you can pass the first code review, then you may not be in the right class!

:hourglass: Each code review is 15 minutes. If we do not have a chance to review your entire project within this time frame, it is likely you will need another code review. As such, make sure you address any easy fixes such as proper formatting and commenting **prior** to the code review to avoid wasting time.

:warning: Remember to [pull any changes](https://help.github.com/articles/fetching-a-remote#pull) made during code review to your local repository! Otherwise, you will end up with [merge conflicts](https://help.github.com/articles/resolving-a-merge-conflict-from-the-command-line) that may be difficult to resolve.

#### Resubmission Process ####

Everyone is expected to resubmit each project 1 to 3 times after their first code review, depending on the project. To resubmit your project:

1. Make sure you have addressed *all* of the issues opened by the instructor during the last code review. (You may close issues as you address them.)

2. Make sure you have updated your project repository on GitHub.

3. Make sure you are still passing all tests.

4. Sign up for another code review appointment using the process outlined above.

:memo: For the most part, project resubmissions will not negatively impact your project grade. However, if you ignore an open issue or sign up for code review before you are passing the necessary tests, your final project score will be docked 5 points for each offense.

