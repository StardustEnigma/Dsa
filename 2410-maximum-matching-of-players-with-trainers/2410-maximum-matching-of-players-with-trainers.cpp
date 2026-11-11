class Solution {
public:
    int matchPlayersAndTrainers(vector<int>& players, vector<int>& trainers) {
        sort(players.begin(),players.end());
        sort(trainers.begin(),trainers.end());

        int player=0,trainer=0;
        while(player <players.size() && trainer<trainers.size()){
            if(players[player] <= trainers[trainer]){
                player++;
            }
            trainer++;
        }
        return player;
    }
};