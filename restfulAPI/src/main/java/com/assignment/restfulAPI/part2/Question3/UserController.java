package com.assignment.restfulAPI.part2.Question3;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Tag(name = "User Management", description = "Endpoints for managing users")
public class UserController {

    private Map<Integer, String> users = new HashMap<>();

    @GetMapping("/{id}")
    @Operation(summary = "Get User", description = "Fetch user details using ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public String getUser(
            @Parameter(description = "User ID", example = "1") @PathVariable int id) {
        return users.getOrDefault(id, "User Not Found");
    }

    @PostMapping("/{id}")
    @Operation(summary = "Save User", description = "Save user details using ID")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "User saved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public String saveUser(
            @Parameter(description = "User ID", example = "1") @PathVariable int id,
            @Parameter(description = "User Name", example = "Samriddhi") @RequestParam String name) {
        users.put(id, name);
        return "User saved successfully!";
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete User", description = "Delete a user by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public String deleteUser(
            @Parameter(description = "User ID", example = "1") @PathVariable int id) {
        users.remove(id);
        return "User deleted successfully!";
    }
}
