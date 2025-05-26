// src/services/api.js
import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api/v1';

const api = {
    getPlayers: () => axios.get(`${API_BASE_URL}/player`),
    getTeams: () => axios.get(`${API_BASE_URL}/team`),
    createTeam: (teamData) => axios.post(`${API_BASE_URL}/teams`, teamData),
    updateTeam: (id, teamData) => axios.put(`${API_BASE_URL}/teams/${id}`, teamData),
    deleteTeam: (id) => axios.delete(`${API_BASE_URL}/teams/${id}`),
};

export default api;
