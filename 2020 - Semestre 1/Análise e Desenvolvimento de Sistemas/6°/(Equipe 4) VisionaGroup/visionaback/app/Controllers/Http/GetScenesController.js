'use strict';

const axios = use('axios');

class GetScenesController {
  async index({ request }) {
    const { cloudCover, dateEnd, dateInit, listIds, coords } = request.post();
    const value = this.normalizeScenes({
      cloudCover,
      dateEnd,
      dateInit,
      listIds,
      coords,
    });
    const { data } = await axios.post(
      `${process.env.IA_ENDPOINT}/generate-mask`,
      value
    );

    return { message: 'ok', ...data };
  }

  normalizeScenes({ cloudCover, dateEnd, dateInit, listIds, coords }) {
    return {
      dateInit: new Date(dateInit),
      dateEnd: new Date(dateEnd),
      cloudCover,
      ids: listIds,
      coordinates: coords,
    };
  }
}

module.exports = GetScenesController;
