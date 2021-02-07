import * as CandidateService from './candidate-service.js'
import * as PopupService from './popup-service.js'

window.voteForCandidate = CandidateService.voteForCandidate;
window.openModal = PopupService.openModal;

window.addEventListener('load', () => {
    const el = $('#app');


    const errorTemplate = Handlebars.compile($('#error-template').html());
    const mainTemplate = Handlebars.compile($('#main-template').html());
    const voteTemplate = Handlebars.compile($('#vote-template').html());
    const liveTemplate = Handlebars.compile($('#live-template').html());
    const faqTemplate = Handlebars.compile($('#faq-template').html());

    const router = new Router({
        mode: 'history',
        page404: (path) => {
            const html = errorTemplate({
                color: 'yellow',
                title: 'Nie znaleziono strony!',
                message: `Adres '/${path}' nie jestnieje!`
            });
            el.html(html);
        },
    });

    router.add('/', () => {
        let html = mainTemplate();
        el.html(html);
    });

    router.add('/vote', async () => {
        let html = voteTemplate();
        el.html(html);
        try {
            const candidates = await CandidateService.fetchFromDb('/candidates');
            html = voteTemplate({candidates});
            el.html(html);
        } catch (error) {
            console.error(error);
        }

    });

    router.add('/live', () => {
        let html = liveTemplate();
        el.html(html);
    });

    router.add('/faq', () => {
        let html = faqTemplate();
        el.html(html);
    });

    router.navigateTo(window.location.pathname);

    const link = $(`a[href$='${window.location.pathname}']`);
    link.addClass('active');

    $('a').on('click', (event) => {
        event.preventDefault();

        const target = $(event.target);
        $('.item').removeClass('active');
        target.addClass('active');

        const href = target.attr('href');
        const path = href.substr(href.lastIndexOf('/'));
        router.navigateTo(path);
    })

    // document.getElementyById('voting-button').addEventListener('click', showVotePopup());
    
});