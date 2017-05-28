import { SportclustersPage } from './app.po';

describe('sportclusters App', () => {
  let page: SportclustersPage;

  beforeEach(() => {
    page = new SportclustersPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
