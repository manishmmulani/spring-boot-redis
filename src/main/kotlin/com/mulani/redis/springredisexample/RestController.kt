package com.mulani.redis.springredisexample

import com.mulani.redis.springredisexample.model.User
import com.mulani.redis.springredisexample.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class RestController(@Autowired
                     val userRepo: UserRepository) {

    @GetMapping("helloworld")
    fun helloWorld(@RequestParam("username") name:String):String {
        return "Hello $name"
    }

    @GetMapping("/")
    fun getAllUsers(): List<User> {
        return userRepo.getAllUsers();
    }

    @GetMapping("/{name}")
    fun getUser(@PathVariable("name") name:String):User? {
        return userRepo.getUser(name);
    }

    @PostMapping("/")
    fun createUser(@RequestBody user:User):User {
        return userRepo.addUser(user);
    }
}