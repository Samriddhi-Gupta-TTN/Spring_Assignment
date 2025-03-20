package com.assignment.restfulAPI.part2.Question5;
import org.springframework.web.bind.annotation.*;

    @RestController
    public class UserControllerV1V2  {

        private final UserVersion1 userV1 = new UserVersion1(1, "Arsh nadeem", "Arsh@tothenew.com");
        private final UserVersion2 userV2 = new UserVersion2(1, "Abhinav Srivastav", "abhinav@tothenew.com", "Sector 62", "7927923820");

        // a) MIME Versioning:accept header versioning
        @GetMapping(value = "/user", produces = "application/vnd.company.app-v1+json")
        public UserVersion1 getUserV1Mime() {
            return userV1;
        }

        @GetMapping(value = "/user", produces = "application/vnd.company.app-v2+json")
        public UserVersion2 getUserV2Mime() {
            return userV2;
        }

        // b) Request Parameter Versioning
        @GetMapping(value = "/user/param", params = "version=1")
        public UserVersion1 getUserV1Param() {
            return userV1;
        }

        @GetMapping(value = "/user/param", params = "version=2")
        public UserVersion2 getUserV2Param() {
            return userV2;
        }


        // c) URI Versioning
        @GetMapping("/v1/user")
        public UserVersion1 getUserV1URI() {
            return userV1;
        }

        @GetMapping("/v2/user")
        public UserVersion2 getUserV2URI() {
            return userV2;
        }

        // d) Request Header Versioning or custom header versioning
        @GetMapping(value = "/user/header", headers = "X-API-VERSION=1")
        public UserVersion1 getUserV1Header() {
            return userV1;
        }

        @GetMapping(value = "/user/header", headers = "X-API-VERSION=2")
        public UserVersion2 getUserV2Header() {
            return userV2;
        }
    }
}
