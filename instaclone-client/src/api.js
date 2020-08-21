export async function login(username, password) {
  var responseData = {
    isSuccessful: false,
    token: "",
  };

  await fetch("/authenticate", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ username: username, password: password }),
  })
    .then((response) => {
      if (response.ok) {
        return response.json();
      } else {
        throw new Error("Bad credentials");
      }
    })
    .then((data) => {
      responseData = {
        isSuccessful: true,
        token: data,
      };
    })
    .catch(() => {});

  return responseData;
}

export async function validateToken(token) {
  var responseData = {
    isValid: false,
  };

  await fetch("/validate_token", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ jwt: token }),
  })
    .then((response) => {
      if (response.ok) {
        responseData.isValid = true;
      } else {
        throw new Error("Invalid token!");
      }
    })
    .catch(() => {});

  return responseData;
}
