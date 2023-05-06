# 대학생 프로젝트 플래너

**Overview**
  * We design a project planner application for univ. student users who join various projects. This report introduces why we chose this application and similar software that is already released on the market. It also shows the database schema and E-R diagram we design in which we implement the application. Then, we demonstrate the software we made. Finally, conclusions are drawn and discussions are conducted. 


<img width="120" alt="그림5" src="https://user-images.githubusercontent.com/90498398/236607550-bf796389-0e38-4fc8-9113-33baeadd0374.png">
<img width="120" alt="그림6" src="https://user-images.githubusercontent.com/90498398/236607558-638928f0-168c-41ce-bfd0-9c09498b99c6.png">
<img width="120" alt="그림7" src="https://user-images.githubusercontent.com/90498398/236607563-270e2f64-358e-4052-86b5-1ee3a3c725c0.png">
<img width="120" alt="그림8" src="https://user-images.githubusercontent.com/90498398/236607638-afd3cf73-9519-4e4f-bf1e-4ccc09180799.png">

실제 구현 화면 (a)프로젝트 (b)프로젝트 생성 중 (c) 로그인 화면 (d) 프로젝트 생성 전

This repository는 우리 팀은 대학생들이 팀프로젝트 과제를 수행할 때, 더 체계적이고 계획적으로 프로젝트를 관리할 수 있는 어플리케이션을 만드는 것을 목표로 한다. 대학생들 대부분 팀 프로젝트 과제를 많이 접하게 된다. 팀 프로젝트의 경우 한 학생이 여러 프로젝트에 들어가고 한 프로젝트에 여러 사람이 들어가 있는데 이럴 경우 각 프로젝트를 전반적으로 관리하는 데이터베이스의 필요성을 느꼈고 이에 따라 본 팀은 이번 데이터베이스 프로젝트 주제를 대학생 팀 프로젝트 관리 데이터베이스로 잡았다. 

팀프로젝트를 단순히 SNS를 통해 공유하고 일정을 잡고 기한과 내용을 정하는 식의 기존 방법으로 당연히 할 수 있다. 하지만 개인이 진행하는 프로젝트의 수는 많아서 자칫 혼란이 생길 수 있다. 또한 프로젝트 상황을 시각적으로 깔끔하게 정리된 형식으로 보면서 진행되는 상황을 실시간으로 확인할 수 있다면 좀 더 원활히 프로젝트를 진행할 수 있을 것이라고 생각되었다. 우리 조가 여기서 집중하는 부분은 팀원들끼리 프로젝트 진행 상황을 공유하게 되어 학생들이 보다 편하게 팀 프로젝트를 수행할 수 있을 것이라고 생각되어서 이런 주제를 선정하게 되었다.

<img width="452" alt="그림9" src="https://user-images.githubusercontent.com/90498398/236607572-19519a10-be8c-48ff-9cce-489f56fc57c3.png">

<img width="402" alt="그림10" src="https://user-images.githubusercontent.com/90498398/236607581-76d8c29a-f5ce-4908-8646-22b415a9f5c6.png">

우리 팀은 SQL로 언어를 선택하고 MySQL workbench IDE를 사용하였다. 서버는 java17버전 java spring boo4를 사용하여 구현하였고 여기서 API를 정의하였다. 또한 앱은 java를 언어로 android studio에서 구현하였다.

## Dependencies
* java17버전
* java spring boot

## Code
Clone this repository into any place you want.
```bash

```

## Quickstart (Demo)
