# GitHub 利用について

## [1] 事前準備
1. [GitHub Account](https://github.com)
2. [Git](https://git-scm.com/downloads)

## [2] SSH Key 設定

SSH キーをGitHubアカウントに追加することで、認証を受けて自分の環境をGitHubサーバーに接続することができます。

1. 既存のSSHの確認  
   `ls -al ~/.ssh`
2. 新しいSSHキーを生成して、ssh-agentに追加する  
   * ed25519アルゴリズムを利用して、SSHキーを生成 `ssh-keygen -t ed25519 -C "your_email@example.com"`
   * ssh-agent起動 `eval $(ssh-agent -s)`
   * ssh-agentにSSHキーを追加 `ssh-add ~/.ssh/id_ed25519`
3. GitHub アカウントにSSHキーを追加
    * SSHキーの中身をコピーする (Windowsの場合)`clip < ~/.ssh/id_ed25519.pub`
    * 自分のアカウントに登録
      1. `Settings`
      2. `SSH and GPG keys` 
      3. `New SSH key`  
      4. [Key]フィールドに貼り付け 
      5. `Add SSH key` 


詳しくは [GitHub Docs](https://docs.github.com/ja/free-pro-team@latest/github/authenticating-to-github/connecting-to-github-with-ssh) にあります。


## [3] UI紹介
以下内容は略
1. Repositories
2. Organization
3. Explore
4. Contribution history
5. Follow, Star, Fork, Contribute
6. Issues and Pull requests

> Tips: GitHubの"文章"は基本markdownで書きます。（絵文字も）

2020年9月[GitHub CLI](https://github.blog/2020-09-17-github-cli-1-0-is-now-available/) がリリースされました、興味ある方ぜひ試してください。

## [4] My First repository

 READMEもない空のrepositoryを作成する場合、初期セットアップ用のコマンドが用意されます。そのまま`Git Bash` に入れればセットアップ可能です。

> Tips: ユーザーIDと同じ名前のRepositoryのREADME.mdはユーザーのプロファイルに表示することができる

## [5] GitHub Pages(静的ウェブサイト)

Repository Name: `ユーザーID.github.io `   



