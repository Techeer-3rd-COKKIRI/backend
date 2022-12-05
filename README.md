# Backend
COKKIRI Backend Repository

서비스 화면
<img width="869" alt="image" src="https://user-images.githubusercontent.com/108508730/205554070-50ab530c-0331-4d09-b0bd-63b98f032507.png">

# 현재 완료된 초기 세팅
- PostgreSQL
- H2 및 테스트용 application.yml
- JIB(gradle.properties을 활용)
- DockerCompose
- Swagger
- GlobalErrorHandler 등 에러관련
- ResultResponse 등 결과 반환 관련
- BaseEntity, AuditingConfig(모든 엔티티에 생성시간, 업데이트시간, 삭제여부 컬럼 추가)
- 서브모듈로 민감한 정보를 담고있는 application.yml 관리
- jacoco
- google java format github action
- pull request, issue(기능구현, 리팩토링, 환경설정, 오류수정) 템플릿
- lombok
