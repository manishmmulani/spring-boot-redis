package com.mulani.redis.springredisexample

import com.mulani.redis.springredisexample.model.User
import com.mulani.redis.springredisexample.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class RestController(@Autowired @Qualifier("redisRepo")
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