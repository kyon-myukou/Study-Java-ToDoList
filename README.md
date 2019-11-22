# TodoList

## 動作環境
* macOS Catalina ver 10.15.1 
* intelliJ IDEA ver 2019.2.4 
* Java 1.8.0_151 
* Gradle 5.6.4
* Spring Boot 2.2.1

## 使用技術
* Spring Boot DevTools
* Thymeleaf
* Spring Data JPA
* MySQL Driver

## 構成

```
.
├── java  
│   └── com  
│       └── kyon  
│           └── todolist  
│               ├── Controller  
│               │   ├── EditListController.java  
│               │   ├── HelloSpring.java  
│               │   ├── SearchListController.java  
│               │   └── TodoListController.java  
│               ├── Database  
│               │   ├── DbRepository.java  
│               │   └── DbTodo.java  
│               └── TodolistApplication.java  
└── resources  
    ├── application.properties  
    ├── static  
    │   └── style.css  
    └── templates  
        ├── edit.html  
        ├── header.html  
        ├── search.html    
        └── todolist.html  
```

* Model  
/java/com/kyon/todolist/Databases 
* Controller  
/java/com/kyon/todolist/Controller
* 静的Vie  
/resources/static
* 動的View  
/resources/templates
 
## 設計
* ヘッダー  
ロゴ及びトップ画面へのリンクと検索へのリンク
* トップ画面  
todoの追加  
未完了のtodoの表示、状態変更、編集へのリンク  
完了済みtodoの表示、状態変更、todoの削除
* 編集画面  
todoの名称変更  
todoの期限変更
* 検索画面
todoの部分一致検索
未完了のtodoの表示、状態変更、編集へのリンク

## 開発環境のセットアップ

* リポジトリをクローン
* プロジェクトをビルド
* mysqlserverを起動
* mysqlにtableを作成 > testdb.txt
* プロジェクトを実行
* `http://localhost:8080/todolist`にアクセス
