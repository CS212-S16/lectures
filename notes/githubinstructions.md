Github Instructions
===================

## Table of Contents ##
- [Setup](#setup)
- [Initial Clone](#initial-clone)
- [Loading Projects into Eclipse](#loading-projects-into-eclipse)
- [Pulling Down New Projects](#pulling-down-new-projects)
- [Submission](#submission)

##Setup
1. Make sure you are using Eclipse Mars and that it is configured to use Java 8.
  1. Download [Eclipse here](https://eclipse.org/)
  2. Download [Java 8 here](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
  3. Make sure that Eclipse is configured correctly. `Eclipse->Preferences->Java->Compiler` should show a "Compiler compliance level" of 1.8 and `Installed JREs` should show Java SE 8. See the professor TA if you need help with this.
2. Install the [Github Desktop](https://desktop.github.com/) for your platform. If you are a Linux user, feel free to use the command line. There are lots of other equivalent tools, but we'll help you out with these. Eclipse also has some integrated support, but you will need to do a few things that aren't easy to do with Eclipse directly. Get used to the command line or a separate tool.

##Initial Clone
The instructor will create for you private repositories for all fo the work you will submit in this class. You should *always* first `clone` or `pull` (that is `update` in SVN terms) the appropriate repository before beginning work. In addition, if the instructor has reviewed your code you must make sure to `pull` any comments or changes *before you make changes*. If you do not, this will lead to unending headache (trust me on this one!).

Your repository names will use the following naming convention: `<github_username>-<repository_name>`, for example `srollins-homework` or `srollins-project`. Your `homework` repository will contain several Eclipse projects and more projects will be added throughout the semester. 

###Using the Github Tool
1. Make sure you have signed in to your github account.
2. Choose `File->Clone Repository`. This will show you a list of all repositories you have available.
3. Choose the appropriate repository, for example `CS212-S16/srollins-homework`, and then select the local directory where you'd like to save the data, for example `/Users/srollins/cs212`.
4. Once you click `Clone` the data will be downloaded and you should be able to use `Finder` or `Explorer` to see it. The Github tool will show you *only* the files that have been changed locally and not pushed to Github. It will not list all files.

##Loading Projects into Eclipse
1. Open Eclipse specifying the local directory indicated in step 3 under Using the Github Tool (e.g., `/Users/srollins/cs212`).
2. Right-click under the `Package Explorer` and select `Import`.
3. Choose `General->Existing Projects into Workspace`.
4. Select the root directory as the directory created by the Github tool (e.g., `/Users/srollins/cs212/srollins-homework`).
5. Select all of the projects you wish to import and click `Finish`.

##Pulling Down New Projects
The instructor will add new projects to your repositories as new work is assigned. In the Github tool, simply `Sync` to pull down the latest updates from github. Then, follow the steps listed in the [Loading Projects into Eclipse](#loading-projects-into-eclipse) section to load the projects into Eclipse and begin work.

##Submission
Commit your changes to Github *early and often*. You should *not* use Github as only a submission tool. Everytime you get a new method or feature working *commit your changes to Github*! 

###Using the Github Tool
1. On the `Changes` screen, select all of the files you wish to commit. This should *not* include classfiles or metadata, but should include any new Java files you have implemented, and any Java or other files you have changed. 
2. In the `Summary` enter a short, meaningful description of the change. Do *not* enter messages such as "commit 1", "commit 2". *DO* enter messages such as "Completed InvertedIndexBuilder parseFile". In the `Description` box provide a more detailed description of the change you have made in this version of the code. 
3. Click `Commit to master`. 
4. Click `Sync` at the top right corner. :warning: don't forget this step!
5. Congratulations! Your changes should be available on Github.

###Hints
1. Make sure your homework is submitted in the homework repository that the instructor has created and that your projects are submitted into the project repository that the instructor has created. 
2. Do not change the name of the Eclipse project the instructor has created for you.
3. Make sure *all* of the files you have changed or added are included. 
4. Verify that all changes have been committed as expected by using the Github website.

###Homework
When submitting homework assignments, the version of your program that is uploaded to Github at the deadline (midnight on the day the work is due) will be graded. You may *not* resubmit homework assignments. 

###Projects
1. Make sure you are passing all tests as described in the [project guidelines](projectguidelines.md).
2. Follow the instructions for [creating a new release](https://help.github.com/articles/creating-releases/) for your project. 
3. The TA and instructor will receive an automated email noting your submission. After your [submission is verified](projectguidelines.md), you will receive an email inviting you to sign up for code review.

