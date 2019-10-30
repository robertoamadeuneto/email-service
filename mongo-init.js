db.createUser(
    {
        user: "email_service",
        pwd: "email_service",
        roles: [
            {
                role: "readWrite",
                db: "email_service"
            }
        ]
    }
)