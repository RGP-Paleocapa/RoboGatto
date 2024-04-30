## Contributing

<!-- We welcome contributions from everyone who is interested in improving and expanding Nevera. If you're excited to contribute, here's how you can get started. -->

### How to Contribute

1. **Familiarize yourself with the project**: Start by reading through the documentation, trying out the project, and understanding its functionality and codebase.

2. **Check the issues**: Look at the existing issues for tasks that need help. If you have a new idea or a bug that is not listed, please open a new issue so it can be discussed.

3. **Fork the repository**: Make a copy of this repository by forking it to your own GitHub account.

4. **Make your changes**: Work on your forked repository. It's a good practice to create a new branch for your changes.

5. **Adhere to coding standards**: Make sure your code follows the existing style to keep the project organized. Include comments where necessary.

6. **Write or update tests**: If you add new features or fix bugs, consider adding new tests or updating existing ones to reflect your changes.

7. **Update documentation**: If your changes require it, update or add documentation to reflect your modifications or new features.

8. **Submit a pull request**: Once your changes are ready, submit a pull request to the main repository. Make sure to describe your changes and link to the issues they resolve.

9. **Review process**: The maintainers will review your pull request. Be open to feedback and be prepared to make further changes if required.

10. **Get merged!**: Once your pull request is approved, it will be merged into the project.

### Basic Git Workflow for Contributions

1. **Clone your forked repository**:
   ```bash
   git clone https://github.com/rgp-paleocapa/RoboGatto
   cd RoboGatto
   ```

2. **Set up the remote upstream (optional but recommended)**:
    ```bash
    git remote add upstream https://github.com/rgp-paleocapa/RoboGatto
    ```

3. **Create a new branch for your changes "-b" to create**:
    ```bash
    git checkout -b your-feature-branch-name
    ```

4. **Make your changes and commit them**:
    ```bash
    git add .
    git commit -m "Add a descriptive commit message here"
    ```
    Use the -b flag with git checkout to create a new branch named your-feature-branch-name and switch to it. This branch will contain the changes you're working on. Remember to use a descriptive name for your branch that reflects the feature or fix you're implementing.

5. **Fetch the latest changes from the upstream before pushing**:
    ```bash
    git fetch upstream
    git rebase upstream/main
    ```

6. **Push your branch to  your Github repository**:
    ```bash
    git push origin your-feature-branch-name
    ```

7. **Submit a pull request**:
    - Go to your repository on Github.
    - You’ll see a Compare & pull request button for your recently pushed branches.
    - Click it, review the changes, and then submit your pull request with a description of your changes.

8. **Keep your fork up to date**:
    ```bash
    git pull upstream main
    git push origin main
    ```


### Additional Guidelines

- **Code of Conduct**: All contributors are expected to follow the project’s Code of Conduct. This ensures a welcoming and supportive environment for all.

- **Licenses and Copyrights**: By contributing, you agree that your contributions will be licensed under the same Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License.

<!-- We look forward to your contributions, and thank you for your interest in helping develop Nevera! -->

<!-- ### Recognition and Credits

We believe in recognizing the hard work and contributions of all our developers. Contributors are acknowledged in our README under the Credits section. Major contributors may also be highlighted in release notes or project documentation. Please make sure to provide accurate information about your contributions to ensure proper acknowledgment. -->
