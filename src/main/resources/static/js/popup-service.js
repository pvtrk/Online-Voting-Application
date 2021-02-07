const VOTE_API = `/vote`;


export function openModal(id){
    $('.ui.basic.modal').modal('show');
    document.querySelector('#confirm-vote-button').addEventListener('click', vote(id));
}

export function vote(id) {
    voteForCandidate(VOTE_API, id);
}