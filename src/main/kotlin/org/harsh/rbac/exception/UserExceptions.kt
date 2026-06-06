package org.harsh.rbac.exception


class UserNotFound(
    var id: Long = 0,
) : RuntimeException()

class UserAlreadyExists(
    var name: String = "",
) : RuntimeException()

