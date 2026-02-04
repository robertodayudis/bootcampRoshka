import axios from "axios";

type LoginRequest = {
  username: string;
  password: string;
};

type AuthResponse = {
  accessToken: string;
};

const BASE_URL = "http://localhost:8080";

export async function login(request: LoginRequest): Promise<AuthResponse> {
  const response = await axios.post<AuthResponse>(
    `${BASE_URL}/api/auth/login`,
    request,
    { headers: { "Content-Type": "application/json" } }
  );

  return response.data;
}
